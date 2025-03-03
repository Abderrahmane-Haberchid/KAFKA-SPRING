package com.abdo.kafkaWork.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishMesssage(String msg){
        log.info(String.format("Sending a new message to test topic $s", msg));
        kafkaTemplate.send("test-topic", msg);
    }
}
