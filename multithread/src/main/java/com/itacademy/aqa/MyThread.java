package com.itacademy.aqa;

public class MyThread extends Thread{
  @Override
  public void run(){
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(Thread.currentThread().getName() + " is running");
  }

  public static void main(String[] args) throws InterruptedException {
    MyThread thread = new MyThread();
    thread.start();

    Thread.sleep(1000);

    System.out.println(Thread.currentThread().getName() + " is finished");
  }
}
