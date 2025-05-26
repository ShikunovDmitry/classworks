package com.itacademy.aqa.factoryMethod;

public class FactoryMethod {
  public static User getUser(String userType) {
    switch (userType) {
      case "admin":
        return new User("admin", "qwaszx@1", "Admin");
      case "editor":
        return new User("editor", "qwaszx@1", "Editor");
      default:
        throw new IllegalArgumentException("Invalid user Type");
    }
  }
}

class User {
  private String userName;
  private String password;
  private String userType;

  public User(String userName, String password, String userType) {
    this.userName = userName;
    this.userType = userType;
    this.password = password;
  }
}
