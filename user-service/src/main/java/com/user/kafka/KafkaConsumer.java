package com.user.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "user-topic", groupId = "user-group")
    public void consume(String message) {
        System.out.println("Received message from user-topic: " + message);
    }
}