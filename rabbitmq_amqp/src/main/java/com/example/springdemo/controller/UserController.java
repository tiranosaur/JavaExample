package com.example.springdemo.controller;

import com.example.springdemo.service.AmqpProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private AmqpProducer amqpProducer;

    @RequestMapping(value = "")
    public ResponseEntity<Void> index() {
        amqpProducer.publishUser();
        return ResponseEntity.ok(null);
    }
}