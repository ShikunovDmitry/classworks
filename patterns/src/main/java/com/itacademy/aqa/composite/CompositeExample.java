package com.itacademy.aqa.composite;

public class CompositeExample{
    public static void main(String[] args) {
      CompositeGraphic compositeGraphic = new CompositeGraphic();

      compositeGraphic.add(new Circle());
      compositeGraphic.add(new Rectangle());

      compositeGraphic.draw();
    }
  }
