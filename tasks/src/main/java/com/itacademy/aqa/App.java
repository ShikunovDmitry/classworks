package com.itacademy.aqa;

class GFG {
  GFG() {
    System.out.println("Constructor");
  }

  static {
    System.out.println("static block");
  }

  {
    System.out.println("instance block");
  }

}

public class App {
  public static void main(String[] args) {
    new GFG();

    System.out.println("--------");
    new GFG();
  }
}
