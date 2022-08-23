package com.example.springdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));");
        SpringApplication.run(Main.class, args);
    }
}
