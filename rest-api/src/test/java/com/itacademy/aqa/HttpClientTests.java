package com.itacademy.aqa;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class HttpClientTests {
  @Test
  public void testPostman() throws IOException {

    HttpClient httpClient = HttpClients.createDefault();

    HttpPost postRequest = new HttpPost("https://postman-echo.com/post");

    postRequest.setHeader("Content-Type", "text/plain");

    HttpEntity body = new StringEntity("{\"Hello\": \"world\"}");

    postRequest.setEntity(body);

    HttpResponse response = httpClient.execute(postRequest);

    Assert.assertEquals(200, response.getStatusLine().getStatusCode());

//    String responseString = EntityUtils.toString(response.getEntity());
//
//    System.out.println(responseString);

    ObjectMapper objectMapper = new ObjectMapper();

//    JsonNode jsonNode = objectMapper.readTree(response.getEntity().getContent().readAllBytes());

//    Assert.assertTrue(jsonNode.get("data").textValue().contains("world"));

    ResponseBody responseBody = objectMapper.readValue(response.getEntity().getContent().readAllBytes(), ResponseBody.class);

    Assert.assertEquals(responseBody.getUrl(), "https://postman-echo.com/post");

    Assert.assertEquals(response.getFirstHeader("Content-Type").getValue(),"application/json; charset=utf-8");

  }
}
