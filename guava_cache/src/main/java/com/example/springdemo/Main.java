package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static String name = "user file name";

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
