package com.itacademy.aqa;

public class ClassExampel {
  int i = 10;
  String name;
  static int k = 4;
  static {
    System.out.println("static block");
  }
  {
    System.out.println(" instance blok");
    name = "John";
  }
  public ClassExampel(){
    System.out.println("Constructor");
    System.out.println(name);
    System.out.println(i);
  }
  double price = 3.14;
  public void instanceMethod(){
    System.out.println("instance method");
  }
  public static void staticMethod(){
    System.out.println("static method");
  }
}


// ClassExampel classExampel = new ClassExampel()
