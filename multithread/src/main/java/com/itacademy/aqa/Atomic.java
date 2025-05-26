package com.itacademy.aqa;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hello world!
 */
public class Atomic {
 private  static AtomicInteger identificator = new AtomicInteger(1);

  public static void main(String[] args) {

    Runnable task = () -> {
      for (int i = 0; i < 30; i++) {
        System.out.println(Thread.currentThread().getName() + " read: " + identificator.getAndIncrement());
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
