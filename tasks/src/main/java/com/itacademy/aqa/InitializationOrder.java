package com.itacademy.aqa;

public class InitializationOrder {
  // Статическое поле
  private static String staticField = initializeStaticField();

  // Нестатическое поле
  private String instanceField = initializeInstanceField();

  // Статический блок
  static {
    System.out.println("1. Static block is executed");
  }

  // Нестатический блок
  {
    System.out.println("3. Instance block is executed");
  }

  // Конструктор
  public InitializationOrder() {
    System.out.println("4. Constructor is executed");
  }

  private static String initializeStaticField() {
    System.out.println("0. Static field is initialized");
    return "Static Field";
  }

  private String initializeInstanceField() {
    System.out.println("2. Instance field is initialized");
    return "Instance Field";
  }

  public static void main(String[] args) {
    System.out.println("Creating first object:");
    new InitializationOrder();

    System.out.println("\nCreating second object:");
    new InitializationOrder();
  }
}
