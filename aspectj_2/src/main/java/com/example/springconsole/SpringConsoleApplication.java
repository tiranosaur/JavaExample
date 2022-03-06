package com.example.springconsole;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringConsoleApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringConsoleApplication.class, args);
    }

    @Autowired
    RestClient client;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(345);
        client.getRequest();
        log.info("2345");
    }
}
