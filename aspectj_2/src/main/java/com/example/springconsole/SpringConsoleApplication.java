package com.example.springconsole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
    }
}
