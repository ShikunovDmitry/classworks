package com.itacademy.aqa;

public class SyncExample {
  public static void main(String[] args) {
    SynchronizedCounter counter = new SynchronizedCounter();

    Runnable task = () -> {
      for (int i = 0; i < 100000; i++) {
        counter.increment();
        counter.getCount();
      }
      System.out.println(Thread.currentThread().getName() + "is finished");
    };

    Thread thread1 = new Thread(task);
    Thread thread2 = new Thread(task);

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Result: " + counter.getCount());


  }
}
