package com.abdo.kafkaWork.consumer;

import com.abdo.kafkaWork.payload.Student;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

//    @KafkaListener(topics = "test-topic", groupId = "myGroup")
//    public void readMsg(String msg){
//        System.out.println("Message received from kafka topic : " + msg);
//    }

    @KafkaListener(topics = "test-topic", groupId = "myGroup")
    public void readMsg(Student msg){
        System.out.println("Message received from kafka topic : " + msg);
    }
}
