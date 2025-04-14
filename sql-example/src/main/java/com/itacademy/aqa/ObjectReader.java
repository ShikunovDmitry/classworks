package com.itacademy.aqa;

import com.itacademy.aqa.dto.EmployeeDto;
import com.itacademy.aqa.utils.ConnectionStringUtil;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class ObjectReader {
  public static void main(String[] args) {


    try {
      Class.forName("org.sqlite.JDBC");
      System.out.println("org.sqlite.JDBC found. You can work");
    } catch (ClassNotFoundException e) {
      System.out.println("org.sqlite.JDBC not found");
      return;
    }

    Connection connection;
    Statement statement;


    try {
      connection = DriverManager.getConnection(ConnectionStringUtil.getConnectionString());
      statement = connection.createStatement();

      String ageQuery = "SELECT DISTINCT FirstName, LastName, DepartmentName,\n" +
          "ROUND((JULIANDAY(Date('now')) - JULIANDAY(Date(pd.DateOfBirth)))/365) as age\n" +
          "FROM Employee e \n" +
          "JOIN PersonalData pd ON pd.EmployeeId = e.EmployeeID\n" +
          "JOIN Department d on e.EmployeeID =d.DepartmentID\n" +
          "JOIN EmployeeSkill es on es.EmployeeId = e.EmployeeID\n" +
          "JOIN Skills s on s.skillId = es.SkillId ";

      ResultSet ageResultSet = statement.executeQuery(ageQuery);

      List<EmployeeDto> employeeDtos = new ArrayList<>();

      while (ageResultSet.next()) {
        employeeDtos.add(new EmployeeDto(ageResultSet.getString(1),
            ageResultSet.getString(2),
            ageResultSet.getString(3),
            ageResultSet.getInt(4)));
      }

      employeeDtos.forEach(EmployeeDto::print);


    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
