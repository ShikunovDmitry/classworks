package com.itacademy.aqa.stepspattern;

import org.junit.jupiter.api.Test;

public class StepsTests {

  @Test
  public void loginTest(){
    UserSteps userSteps = new UserSteps();

    userSteps
        .openHomePage()
        .registerUser()
        .loginUser()
        .checkingUser();
  }
}
