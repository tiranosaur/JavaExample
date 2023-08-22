package com.example.springdemo.controller;

import com.example.springdemo.data.TestDTO;
import com.example.springdemo.util.JsonPreparer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import static java.util.concurrent.TimeUnit.MINUTES;

@Slf4j
@RestController
public class TestController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private final Random random = new Random();


    @GetMapping("index")
    public ResponseEntity<?> index() {
        return ResponseEntity.ok().body(create("fuck"));
    }

    @SneakyThrows
    private TestDTO create(String message) {
        int i = random.nextInt(10);
        String history = redisTemplate.opsForValue().get("" + i);
        if (history != null) {
            return JsonPreparer.convert(history, new TypeReference<>() {
            });
        }

        try {
            Thread.sleep(2000);
            TestDTO testDTO = new TestDTO();
            testDTO.setMessage(message);
            testDTO.setId(i);
            Boolean notReserved = redisTemplate.opsForValue().setIfAbsent("" + i, JsonPreparer.toString(testDTO), 1, MINUTES);
            if (notReserved) {
                log.error("[{}]", JsonPreparer.toString(testDTO));
            }
            return testDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
