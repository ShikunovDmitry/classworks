package com.itacademy.aqa.composite;

import java.util.ArrayList;
import java.util.List;

public interface Graphic {
  void draw();
}

class Circle implements Graphic {
  @Override
  public void draw() {
    System.out.println("Draw a circle");
  }
}

class Rectangle implements Graphic {
  @Override
  public void draw() {
    System.out.println("Draw a rectangle");
  }
}

class CompositeGraphic implements Graphic {
  List<Graphic> graphics = new ArrayList<>();

  public void add(Graphic graphic) {
    graphics.add(graphic);
  }

  @Override
  public void draw() {
    for (Graphic graphic : graphics) {
      graphic.draw();
    }
  }
}

