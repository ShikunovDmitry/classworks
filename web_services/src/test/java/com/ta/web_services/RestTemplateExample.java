package com.ta.web_services;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

public class RestTemplateExample {
    String url = "http://jsonplaceholder.typicode.com/posts/1";
    @Test
    public void verifyGet() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
//        User result = restTemplate.getForObject(url, User.class);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        System.out.println(response.getBody().toString());
//        System.out.println(result.toString());
    }

    @Test
    public void verifyPut() throws Exception {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", 1);
        requestBody.put("title", "foo");
        requestBody.put("body", "bar");
        requestBody.put("userId", "1");
        // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(requestBody.toString(), headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate
                .exchange(url, HttpMethod.PUT, entity, String.class);
        System.out.println(response.getBody().toString());
    }
}
