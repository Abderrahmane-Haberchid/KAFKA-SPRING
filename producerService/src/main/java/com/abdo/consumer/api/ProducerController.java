package com.abdo.consumer.api;

import com.abdo.consumer.producer.ProducerService;
import com.abdo.consumer.stream.WikimediaStreamConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wikimedia")
public class ProducerController {
    private final ProducerService producerService;
    private final WikimediaStreamConsumer wikimediaStreamConsumer;

    public ProducerController(ProducerService producerService, WikimediaStreamConsumer wikimediaStreamConsumer){
        this.producerService = producerService;
        this.wikimediaStreamConsumer = wikimediaStreamConsumer;
    }

    @GetMapping
    public void startConsuming(){
        wikimediaStreamConsumer.consumeStreamAndPublish();
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody String msg){
        producerService.publish(msg);
        return new ResponseEntity<>("Message queued in the topic", HttpStatus.OK);
    }
}
