package com.itacademy.aqa.dto;

public class EmployeeDto {
  String firstName;
  String lastName;
  String departmentName;
  Integer age;

  public EmployeeDto(String lastName, String firstName, String departmentName, Integer age) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.departmentName = departmentName;
    this.age = age;
  }

  public Integer getAge() {
    return age;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void print(){
    System.out.println(firstName + "\t" + lastName + "\t" + departmentName + "\t" + age);
  }


}
