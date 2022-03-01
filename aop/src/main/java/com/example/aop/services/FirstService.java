package com.example.aop.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FirstService {
    public void delay() throws InterruptedException {
        Thread.sleep(500);
        log.info("+");
    }
}
