package com.example.spring.controller;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@RestController
public class MainController {
    @GetMapping("/")
    public ResponseEntity<Object> index() throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://filesamples.com/samples/code/json/sample1.json"))
                .header("content-type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() == 200) {
            String body = response.body();
            ObjectMapper mapper = new ObjectMapper();
            Fruit fruit = mapper.readValue(body, Fruit.class);
            return ResponseEntity.ok(fruit);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Fruit implements Serializable {
    @JsonProperty(value = "fruit")
    private String fruit;
    private String size;
    private String color;
}