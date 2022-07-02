package com.example.springdemo.service;

import com.example.springdemo.constant.ApplicationConstant;
import com.example.springdemo.model.User;
import com.example.springdemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public List<User> getAll() {
        log.info("UserService.getAll users");
        return userRepository.findAll();
    }

    public void sendAllToKafka() {
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            try {
                kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, user);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
