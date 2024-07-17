package com.example.redismessanger.controller;

import com.example.redismessanger.service.RedisMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    @PostMapping("/")
    public void publishMessage(@RequestParam String message) {
        redisMessagePublisher.publish(message);
    }
}
