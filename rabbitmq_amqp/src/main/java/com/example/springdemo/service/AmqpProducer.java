package com.example.springdemo.service;

import com.example.springdemo.model.User;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AmqpProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void publishUser() {
        User user = new User(UUID.randomUUID(), "test User", 42);
        rabbitTemplate.convertAndSend(queue.getName(), user);
    }
}
