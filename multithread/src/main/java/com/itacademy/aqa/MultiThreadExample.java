package com.itacademy.aqa;

import java.util.Random;

public class MultiThreadExample {
  public static void main(String[] args) {

    Runnable task = () ->{
      for (int i = 0; i<20; i++){
        System.out.println(Thread.currentThread().getName() + " is running");
        try {
          Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

      }
      System.out.println(Thread.currentThread().getName() + " is winner");
    };

    Thread thread1 = new Thread(task);
    Thread thread2 = new Thread(task);
    Thread thread3 = new Thread(task);

    thread1.start();
    thread2.start();
    thread3.start();

  }
}
