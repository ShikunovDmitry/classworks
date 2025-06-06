package com.itacademy.aqa;

public class Polyndrome {
  public static void main(String[] args) {
    System.out.println("-----------------------------");
    String s = "Radar";

    String ss = s.replace(" ", "").toLowerCase();


    if (ss.equals((new StringBuffer(ss)).reverse().toString())) {
      System.out.print("Polyndrome Yes");
    } else {
      System.out.print("Polyndrome No");
    }

    System.out.println("---------------------------------");
    boolean palindrom = true;

    int left = 0;
    int right = ss.length() - 1;

    while (left < right) {
      if (ss.charAt(left) != ss.charAt(right)) {
        palindrom = false;
      }
      left++;
      right--;
    }
    System.out.println("Palindrom: " + palindrom);

  }


}
