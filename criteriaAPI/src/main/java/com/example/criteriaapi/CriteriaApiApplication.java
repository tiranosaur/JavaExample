package com.example.criteriaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CriteriaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CriteriaApiApplication.class, args);
        System.out.println("http://localhost:8084/article/index1");
        System.out.println("http://localhost:8084/article/index2");
        System.out.println("http://localhost:8084/article/index3");
        System.out.println("http://localhost:8084/article/index4");
    }

}
