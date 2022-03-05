package com.example.client;

import com.example.client.client.PublicFeignClient;
import com.example.client.client.RestClient;
import com.example.client.service.TestExternalService;
import com.utils.retryLibrary.TestRetryLibrary;
import com.utils.retryLibrary.aspect.RetryClientAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RetryClientAspect.class)
@EnableFeignClients
public class ClientApplication implements CommandLineRunner {
    @Autowired
    TestExternalService service;

    @Autowired
    PublicFeignClient feignClient;

    @Autowired
    RestClient restClient;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------------------");
        TestRetryLibrary.test();
        System.out.println("-------------------");
        service.test(true);
        System.out.println("-------------------");
        System.out.println(feignClient.getRequest());
        System.out.println("-------------------");
        System.out.println(restClient.getRequest());
    }
}
