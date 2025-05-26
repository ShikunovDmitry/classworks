package com.itacademy.aqa.proxy;

public class ProxyExample {
  public static void main(String[] args) {
    File file = new ProxyFile("hello.txt");
    file.read();

    file.read();
  }
}
