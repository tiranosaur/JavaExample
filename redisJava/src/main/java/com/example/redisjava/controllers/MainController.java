package com.example.redisjava.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Random;

@RestController
public class MainController {
    private Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> index() {
        String key = "test_key";
        Random rnd = new Random();
        Integer value = rnd.nextInt();
        LOGGER.info("new value is {}", value);
        String response = "";

        if (redisTemplate.hasKey(key)) {
            response = redisTemplate.opsForValue().get(key).toString();
        }
        redisTemplate.opsForValue().set(key, value);

        return ResponseEntity.ok(response);
    }
}
