package com.ta.web_services;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.apache.http.HttpHeaders.USER_AGENT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HttpClientExample {
    @Test
    public void verifyStatusCode() throws Exception {
        sendGet();
//        sendPut();
//        sendDelete();
    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "http://jsonplaceholder.typicode.com/posts";

        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("User-Agent", USER_AGENT);

        HttpResponse response = client.execute(request);

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));

    }

    //HTTP Post request
    private void sendPut() throws Exception {
        HttpClient client = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut("http://jsonplaceholder.typicode.com/posts/1");

        String json = "{\"id\": 1,\n" +
                "\"title\": 'foo',\n" +
                "\"body': 'bar',\n" +
                "\"userId\": 1\n" +
                "}";
        StringEntity entity = new StringEntity(json);
        httpPut.setEntity(entity);
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-type", "application/json");

        HttpResponse response = client.execute(httpPut);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
    }

    // HTTP Delete request
    private void sendDelete() throws Exception {
        String url = "http://jsonplaceholder.typicode.com/posts/1";
        HttpClient client = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(url);


        httpDelete.setHeader("Accept", "application/json");

        HttpResponse response = client.execute(httpDelete);
        System.out.println("Status Code = " + response.getStatusLine().getStatusCode());
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));

    }
}
