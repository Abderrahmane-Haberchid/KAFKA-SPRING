package com.abdo.kafkaWork.api;

import com.abdo.kafkaWork.payload.Student;
import com.abdo.kafkaWork.producer.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody String msg){
        kafkaProducer.publishMessage(msg);
        return new ResponseEntity<>("Message published successfully!", HttpStatus.OK);
    }

    @PostMapping("/publishJson")
    public ResponseEntity<String> sendJson(@RequestBody Student student){
        kafkaProducer.publishJsonStudent(student);
        return new ResponseEntity<>("Student sent to topic successufully", HttpStatus.OK);
    }
}
