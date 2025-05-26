package com.itacademy.aqa;

/**
 * Hello world!
 */
public class ThreadLocalExample {
  private static ThreadLocal<Integer> threadLocalCounter = ThreadLocal.withInitial(() -> 0);
//    private static int threadLocalCounter = 0;

  public static void main(String[] args) {

    Runnable task = () -> {
      for (int i = 0; i < 30; i++) {
        int counter = threadLocalCounter.get();
        System.out.println(Thread.currentThread().getName() + " read: " + counter);
        threadLocalCounter.set(counter + 1);
      }
    };

    Thread thread1 = new Thread(task);
    Thread thread2 = new Thread(task);
    Thread thread3 = new Thread(task);

    thread1.start();
    thread2.start();
    thread3.start();

  }
}
