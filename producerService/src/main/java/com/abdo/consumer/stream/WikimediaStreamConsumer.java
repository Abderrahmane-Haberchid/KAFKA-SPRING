package com.abdo.consumer.stream;

import com.abdo.consumer.producer.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WikimediaStreamConsumer {

    private final WebClient webClient;
    private final ProducerService producerService;

    public WikimediaStreamConsumer(WebClient.Builder webclient, ProducerService producerService){
        this.webClient = webclient.baseUrl("https://stream.wikimedia.org/v2").build();
        this.producerService = producerService;
    }

    public void consumeStreamAndPublish(){
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux((String.class))
                .subscribe(producerService::publish);
    }


}
