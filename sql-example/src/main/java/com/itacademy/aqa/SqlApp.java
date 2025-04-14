package com.itacademy.aqa;

import com.itacademy.aqa.dto.EmployeeDto;
import com.itacademy.aqa.utils.ConnectionStringUtil;

import java.sql.*;

public class SqlApp {
  public static final String ADD_EMPLOYEE_QUERY =
      "INSERT INTO Employee(EmployeeId, FirstName, LastName, DepartmentId) values(?, ?, ?, ?)";

  public static void main(String[] args) {
    EmployeeDto employeeDto = new EmployeeDto("Dmitry", "Shikunov", "Sales", 41);
    createEmployee(employeeDto);
  }

  public static void createEmployee(EmployeeDto employeeDto) {
    try (PreparedStatement preparedStatement =
             DriverManager.getConnection(ConnectionStringUtil.getConnectionString()).prepareStatement(ADD_EMPLOYEE_QUERY)) {
      preparedStatement.setInt(1, getNextEmployeeId());
      preparedStatement.setString(2, employeeDto.getFirstName());
      preparedStatement.setString(3, employeeDto.getLastName());
      preparedStatement.setInt(4, getDepartmentIdByName(employeeDto.getDepartmentName()));
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static Integer getNextEmployeeId() {
    try (Statement statement = DriverManager.getConnection(ConnectionStringUtil.getConnectionString()).createStatement()) {
      ResultSet resultSet = statement.executeQuery("SELECT MAX(EmployeeId) as max FROM Employee");

      if (resultSet.next()) {
        return resultSet.getInt("max") + 1;
      } else {
        return 1;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static Integer getDepartmentIdByName(String departmentName) {
    try (Statement statement = DriverManager.getConnection(ConnectionStringUtil.getConnectionString()).createStatement()) {
      ResultSet resultSet = statement.executeQuery(String.format("SELECT DepartmentID from Department WHERE DepartmentName = '%s'",
          departmentName
      ));
      if (resultSet.next()) {
        return resultSet.getInt("DepartmentID");
      } else {
        throw new RuntimeException("Department is not exist " + departmentName);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
