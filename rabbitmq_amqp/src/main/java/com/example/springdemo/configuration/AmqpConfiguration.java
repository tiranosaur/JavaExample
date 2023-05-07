package com.example.springdemo.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.springdemo.Constant.AMQP_USER_PUBLISH_KEY;

@Configuration
public class AmqpConfiguration {
    @Bean
    public Queue ueue() {
        return new Queue(AMQP_USER_PUBLISH_KEY, false);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
