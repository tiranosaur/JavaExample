package com.example.springconsole;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Slf4j
public class SpringConsoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConsoleApplication.class, args);
    }

}
