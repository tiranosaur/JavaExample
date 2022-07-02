package com.example.springdemo.controller;

import com.example.springdemo.model.User;
import com.example.springdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "")
    public ResponseEntity<List<User>> index() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("")
    public void sendMessage() {
        userService.sendAllToKafka();
    }
}