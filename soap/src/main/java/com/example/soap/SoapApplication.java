package com.example.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapApplication.class, args);
        System.out.println("curl -H \"Content-Type: text/xml\" -d @request.xml http://localhost:8084/ws\n");
    }
}
