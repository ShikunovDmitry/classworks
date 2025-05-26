package com.itacademy.aqa.decorator;

public class DecoratorExample {
  public static void main(String[] args) {
    TextProcessor basicProcessor = new SimpleTextProcessor();

    System.out.println(basicProcessor.process("hello basic decorator"));

    TextProcessor upperCaseDecorator = new UpperCaseDecorator(basicProcessor);

    System.out.println(upperCaseDecorator.process("hello upper case decorator"));

    TextProcessor surroundWithQuotesDecorator = new SurroundWithQuotesDecorator(basicProcessor);

    System.out.println(surroundWithQuotesDecorator.process("hello surround decorator"));


  }
}
