package com.itacademy.aqa;

public class MyRunnable implements Runnable{
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " is running");
  }

  public static void main(String[] args) throws InterruptedException {
    MyRunnable myRunnable = new MyRunnable();

    Thread thread = new Thread(myRunnable);

    thread.start();

    thread.join();

    System.out.println(Thread.currentThread().getName() + " is finished");
  }
}
