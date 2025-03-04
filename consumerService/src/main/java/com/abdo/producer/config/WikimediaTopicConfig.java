package com.abdo.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class WikimediaTopicConfig {
    @Bean
    public NewTopic createTopic(){
        return TopicBuilder
                .name("wikimedia-topic")
                .build();
    }
}
