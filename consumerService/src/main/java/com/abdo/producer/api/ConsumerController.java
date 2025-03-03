package com.abdo.producer.api;

import com.abdo.producer.consumer.ConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/consumer")
public class ConsumerController {
    private final ConsumerService consumerService;

    public ConsumerController(ConsumerService consumerService){
        this.consumerService = consumerService;
    }

    @GetMapping
    public void getStream(@RequestBody String msg){
        consumerService.consumeStream(msg);
    }
}
