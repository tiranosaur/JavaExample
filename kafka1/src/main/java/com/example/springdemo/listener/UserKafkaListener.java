package com.example.springdemo.listener;

import com.example.springdemo.constant.ApplicationConstant;
import com.example.springdemo.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserKafkaListener {
	@KafkaListener(
			groupId = ApplicationConstant.GROUP_ID_JSON,
			topics = ApplicationConstant.TOPIC_NAME,
			containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY
	)
	public void receivedMessage(User user) throws JsonProcessingException {
		log.error("Json message received using Kafka listener " + user);
	}
}
