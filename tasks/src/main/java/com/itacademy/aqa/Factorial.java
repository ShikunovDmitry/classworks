package com.itacademy.aqa;

//Задание 3: Факториал числа
//3! = 1 + 2 + 3

public class Factorial {
  public static void main(String[] args) {

    System.out.println(factorial(7));
    System.out.println(fac(7));
  }

  static int factorial(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Must not be negative");
    }
    int result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
    }
    return result;
  }

  //1,2,3,4,5,6,7
  //10! = 1*2*3*4*5*6*7
  static int fac(int n) {
    if (n <= 1) {
      return 1;
    } else {
      return n * fac(n - 1);
    }
  }


}
