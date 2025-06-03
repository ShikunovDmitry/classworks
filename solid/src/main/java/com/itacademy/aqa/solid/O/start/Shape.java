package com.itacademy.aqa.solid.O.start;

public class Shape {

  public double calculateArea(){
    return 0;
  }

  class Curcle  extends Shape{
    private double radius;
    public double calculateArea(){
      return Math.PI * radius * radius;
    }
  }

  class Rectangle  extends Shape{
    private double a;
    private double b;

    public double calculateArea(){
      return a * b;
    }
  }
}
