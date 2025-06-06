package com.itacademy.aqa;

import java.util.Arrays;
import java.util.List;

public class FilterTask {
  public static void main(String[] args) {

    List<Person> people = Arrays.asList(
        new Person("Alice", 20),
        new Person("Bob", 17),
        new Person("Charlie", 22)
    );

    for (Person person: people){
      if(person.getAge() > 18){
        System.out.println(person.getName());
      }
    }
    System.out.println("____________________");

    people.stream()
        .filter(person -> person.getAge()>18)
        .map(Person::getName)
        .forEach(System.out::println);

  }
}

class Person {
  String name;
  int age;

  Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String  toString(){
    return this.getName() + "|" + this.getAge();
  }


}
