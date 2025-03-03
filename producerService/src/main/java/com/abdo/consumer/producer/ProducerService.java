package com.abdo.consumer.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(String msg){
        kafkaTemplate.send("wikimedia-topic", msg);
    }
}
