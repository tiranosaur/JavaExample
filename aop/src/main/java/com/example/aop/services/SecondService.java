package com.example.aop.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SecondService {
    private static int counter = 0;

    public void delay() throws InterruptedException {
        Thread.sleep(5000);
        log.info("++");
    }

    public void retry() throws InterruptedException {
        log.info("counter = {}", counter++);
        Thread.sleep(5000);
    }
}