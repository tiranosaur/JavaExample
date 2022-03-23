package com.example.springconsole;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringConsoleApplication {
    private final Logger LOGGER = LoggerFactory.getLogger(SpringConsoleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringConsoleApplication.class, args);
    }
}