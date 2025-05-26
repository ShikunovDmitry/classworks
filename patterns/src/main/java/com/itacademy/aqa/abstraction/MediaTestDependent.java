package com.itacademy.aqa.abstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class MediaTestDependent extends BaseTest{

  @BeforeEach
  public void testInit(){
    //Login
    //go to media page
  }

  @Test
  @Order(1)
  public void  testUploadFile(){
    //upload a file
    //assert file is uploaded
  }

  @Test
  @Order(2)
  public void  testDeleteFile(){
    //delete a file
    //assert file is deleted
  }
}
