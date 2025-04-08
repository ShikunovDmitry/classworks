package com.itacademy.aqa;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class RestAssuredTests {

  @Test
  public void restAssuredTest(){

    Response response = given().log().all()
        .headers("Content-Type", ContentType.TEXT)
        .body("{\"Hello\": \"world\"}")
        .post("https://postman-echo.com/post")
        .then()
        .statusCode(200).extract().response();

    System.out.println(response.prettyPrint());

  }

  @Test
  public void restAssuredTest2(){

    String data = given().log().all()
        .headers("Content-Type", ContentType.TEXT)
        .body("{\"Hello\": \"world\"}")
        .post("https://postman-echo.com/post")
        .then()
        .statusCode(200).extract().path("data");

    System.out.println(data);

  }

  @Test
  public void restAssuredTestExtract(){

    ResponseBody data = given().log().all()
        .headers("Content-Type", ContentType.TEXT)
        .body("{\"Hello\": \"world\"}")
        .queryParam("param","value")
        .post("https://postman-echo.com/post")
        .then().log().all()
        .statusCode(200).extract().body().as(ResponseBody.class);

    Assert.assertTrue(data.getData().toString().contains("world"));

  }
}
