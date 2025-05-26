package com.itacademy.aqa.adapter;

public class Adapter implements NewSystem{
  private OldSystem oldSystem;

  public Adapter(OldSystem oldSystem){
    this.oldSystem = oldSystem;
  }
  @Override
  public void newMethod() {
    this.oldSystem.oldMethod();
  }

  public static void main(String[] args) {
    OldSystem oldSystem1 = new OldSystem();

    NewSystem adapter = new Adapter(oldSystem1);
    adapter.newMethod();
  }
}
