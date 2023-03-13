package com.example.springdemo.controller;

import com.example.springdemo.repository.ChatMessageRepository;
import com.mongodb.client.MongoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MainController {
    @Autowired
    ChatMessageRepository chatMessageRepository;
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping(value = "")
    public ResponseEntity index() {
        var xxx = mongoTemplate.getCollection("chat_message").countDocuments();
        var zzz = chatMessageRepository.findAll();
        return ResponseEntity.ok(zzz);
    }
}