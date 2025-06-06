package com.itacademy.aqa.people;

class People {

    private final int empId;
    private final String name;

    private static int nextId = 0;

    public People(String name) {
        this.name = name;
        this.empId = ++nextId;
    }

    public void display() {
        System.out.println("The employee id for " + name + " is " + empId);
    }
}

public class Main {
    public static void main(String[] args) {
        People people1 = new People("Kamal");
        people1.display();

        People people2 = new People("Dmytro");
        people2.display();

        People people3 = new People("John");
        people3.display();
    }
}