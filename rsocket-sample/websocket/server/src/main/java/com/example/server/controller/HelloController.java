package com.example.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@Slf4j
@RestController
public class HelloController {
    @GetMapping
    public String get() {
        log.info("----- HelloController.get instant - [{}]", Instant.now());
        return "server greeting at :" + Instant.now();
    }
}
