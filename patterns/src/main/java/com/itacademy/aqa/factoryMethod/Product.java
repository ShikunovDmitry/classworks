package com.itacademy.aqa.factoryMethod;

// Общий продукт
interface Product {
  void use();
}

// Конкретные продукты
class ConcreteProductA implements Product {
  @Override
  public void use() {
    System.out.println("Используется продукт A");
  }
}

class ConcreteProductB implements Product {
  @Override
  public void use() {
    System.out.println("Используется продукт B");
  }
}

// Абстрактная фабрика
abstract class Creator {
  public abstract Product createProduct();
}

// Конкретные фабрики
class ConcreteCreatorA extends Creator {
  @Override
  public Product createProduct() {
    return new ConcreteProductA();
  }
}

class ConcreteCreatorB extends Creator {
  @Override
  public Product createProduct() {
    return new ConcreteProductB();
  }
}
