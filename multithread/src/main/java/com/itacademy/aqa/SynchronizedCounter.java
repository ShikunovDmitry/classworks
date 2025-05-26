package com.itacademy.aqa;

public class SynchronizedCounter {
  private int count = 0;

  public synchronized int getCount() {
    return count;
  }

  public synchronized void increment()
  {
    count++;
  }

}
