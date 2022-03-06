package com.example.springconsole;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringConsoleApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.printf("%d\n ", 2345);
        execute();
    }
    public static void execute(){
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet uploadFile = new HttpGet("https://filesamples.com/samples/code/json/sample1.json");

            CloseableHttpResponse response = httpClient.execute(uploadFile);
            HttpEntity responseEntity = response.getEntity();

            String responseString = EntityUtils.toString(responseEntity, "UTF-8");
            System.out.println(responseString);
            httpClient.close();
        } catch (Exception e) {
        }
    }
}
