package com.itacademy.aqa;

import java.io.Serializable;

public class Employee implements Serializable {
    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

    private String lastName;
    private Integer age;

    public Employee(String name, String surname, int age) {
        this.age = age;
        this.firstName = name;
        this.lastName = surname;
    }
}
