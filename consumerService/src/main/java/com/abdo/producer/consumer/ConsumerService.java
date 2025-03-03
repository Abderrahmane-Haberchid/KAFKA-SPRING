package com.abdo.producer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "wikimedia-topic", groupId = "myGroup")
    public void consumeStream(String msg){
        System.out.println(msg);
    }
}
