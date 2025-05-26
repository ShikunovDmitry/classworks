package com.itacademy.aqa.builder;

public class User {
  private String userName;
  private String password = "change me";
  private String role;

  private User(Builder builder) {
    this.userName = builder.userName;
    this.password = builder.password;
    this.role = builder.role;
  }

  public static class Builder{
    private String userName;
    private String password;
    private String role;

    public Builder withUserName(String userName){
      this.userName = userName;
      return this;
    }

    public Builder withPassword(String password){
      this.password = password;
      return this;
    }

    public Builder withRole(String role){
      this.role = role;
      return this;
    }

    public User build(){
      return new User(this);
    }


  }
}
