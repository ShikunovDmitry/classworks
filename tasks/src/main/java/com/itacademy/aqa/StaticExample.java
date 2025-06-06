package com.itacademy.aqa;

// нужно сделать таким образом, чтобы каждый раз при
// создании обьекта генерировалася новый уникальный empId(id)
class People {

  //1-1
  private static int empId;
  //2-1
  private String name;
  //1-2
  static{
    empId++;
  }
  //2-2
  public People(String name){
    this.name = name;
  }
  public void display(){
    System.out.println("The employee id for "+ name +" is "+ empId);
  }
}

public class StaticExample {
  public static void main(String[] args) {
    People people1 = new People("Kamal");//1
    people1.display();
    People people2 = new People("Dmytro");//2
    people2.display();
    people1 = new People("John");//3
    people1.display();

  }
}
