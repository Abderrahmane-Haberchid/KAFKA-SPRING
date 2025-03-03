package com.abdo.kafkaWork.producer;


import com.abdo.kafkaWork.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishMessage(String msg){
        kafkaTemplate.send("test-topic", msg);
    }

    public void publishJsonStudent(Student student) {
        Message<Student> message = MessageBuilder
                .withPayload(student)
                        .setHeader(KafkaHeaders.TOPIC, "test-topic")
                                .build();
        kafkaTemplate.send(message);
    }

}
