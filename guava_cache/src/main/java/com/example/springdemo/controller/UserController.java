package com.example.springdemo.controller;

import com.example.springdemo.model.User;
import com.example.springdemo.repository.UserRepository;
import com.example.springdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "")
    public ResponseEntity<List<User>> index() {
        var x1 = userRepository.findAll();
        var x2 = userRepository.findAll();
        var x3 = userRepository.findAll();
        var x4 = userRepository.findAll();

        return ResponseEntity.ok(userService.getAll());
    }
}