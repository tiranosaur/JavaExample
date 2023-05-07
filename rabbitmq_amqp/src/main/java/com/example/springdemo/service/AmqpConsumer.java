package com.example.springdemo.service;

import com.example.springdemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static com.example.springdemo.Constant.AMQP_USER_PUBLISH_KEY;

@Slf4j
@Service
public class AmqpConsumer {
    @RabbitListener(queues = AMQP_USER_PUBLISH_KEY)
    public void listen(User user) {
        log.warn("AmqpConsumer.listen user - {}", user);
    }
}
