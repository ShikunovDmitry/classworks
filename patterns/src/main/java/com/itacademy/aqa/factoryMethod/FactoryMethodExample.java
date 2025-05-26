package com.itacademy.aqa.factoryMethod;

public class FactoryMethodExample {
  public static void main(String[] args) {
    Creator creator = new ConcreteCreatorA();

    Product product = creator.createProduct();

    product.use();
  }
}
