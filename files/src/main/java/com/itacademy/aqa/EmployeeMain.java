package com.itacademy.aqa;

import java.io.*;

public class EmployeeMain {
  public static void main(String[] args) {

    Employee employee = new Employee("John", "Doe", 25);

    try (FileOutputStream fos = new FileOutputStream("employee.data");
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      oos.writeObject(employee);

    } catch (FileNotFoundException e) {
      System.out.println("file not found");
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (FileInputStream fis = new FileInputStream("employee.data");
         ObjectInputStream ois = new ObjectInputStream(fis)) {

      Employee emp = (Employee) ois.readObject();
      System.out.println(emp.getFirstName());
      System.out.println(emp.getLastName());
      System.out.println(emp.getAge());

    } catch (FileNotFoundException e) {
      System.out.println("file not found");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

  }
}
