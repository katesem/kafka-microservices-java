package com.recommendation.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "recommendations-topic")
    public void listen(String message) {

        System.out.println("Received Message: " + message);
    }
}