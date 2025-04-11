package com.itacademy.aqa;

import io.restassured.http.ContentType;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class JsonSchemaTest {
    @Test
    public void restAssuredTest() {
        given()
                .header("Content-Type", ContentType.JSON)
                .body("{\"Hello\": \"world\"}")
                .queryParams("key","value")
                .post("https://postman-echo.com/post")
                .then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchema(new File("src/schema.json")));

    }
}
