package com.example.spring.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DebeziumConsumer {

    @KafkaListener(topics = "db-changes.worker.romanoff_test_test_test_test_test_test_test_test_test_test", groupId = "my-group")
    public void consume(ConsumerRecord<String, String> record) throws Exception {
        String originalMessage = record.value();

        // BREAKPOINT

        log.info("----- {}", originalMessage);
    }
}
