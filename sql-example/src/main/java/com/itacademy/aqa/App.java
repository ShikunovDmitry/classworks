package com.itacademy.aqa;

import com.itacademy.aqa.utils.ConnectionStringUtil;

import java.io.File;
import java.sql.*;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {


    try {
      Class.forName("org.sqlite.JDBC");
      System.out.println("org.sqlite.JDBC found. You can work");
    } catch (ClassNotFoundException e) {
      System.out.println("org.sqlite.JDBC not found");
      return;
    }


    try (Statement statement = DriverManager.getConnection(ConnectionStringUtil.getConnectionString()).createStatement()) {

      String query = "SELECT * FROM Employee";

      ResultSet resultSet = statement.executeQuery(query);

      while (resultSet.next()) {
        System.out.printf("User Name: " + resultSet.getString(2) + "\t\t");
        System.out.println("Last Name: " + resultSet.getString("LastName"));
      }

      String ageQuery = "SELECT DISTINCT FirstName, LastName,\n" +
          "ROUND((JULIANDAY(Date('now')) - JULIANDAY(Date(pd.DateOfBirth)))/365) as age\n" +
          "FROM Employee e \n" +
          "JOIN PersonalData pd ON pd.EmployeeId = e.EmployeeID\n" +
          "JOIN Department d on e.EmployeeID =d.DepartmentID\n" +
          "JOIN EmployeeSkill es on es.EmployeeId = e.EmployeeID\n" +
          "JOIN Skills s on s.skillId = es.SkillId ";

      ResultSet ageResultSet = statement.executeQuery(ageQuery);

      while (ageResultSet.next()) {
        System.out.printf("User Name: " + ageResultSet.getString("FirstName") + "\t");
        System.out.printf("Last Name: " + ageResultSet.getString("LastName") + "\t");
        System.out.printf("Age: " + ageResultSet.getInt("age") + "\t");
        System.out.println();
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
