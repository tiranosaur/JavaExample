package com.example.springdemo.service;

import com.example.springdemo.model.User;
import com.example.springdemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> getAll(){
        log.info("UserService.getAll users");
        return userRepository.findAll();
    }
}
