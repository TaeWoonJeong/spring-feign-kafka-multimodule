package com.jose.consumer.listener;

import com.google.gson.Gson;
import com.jose.consumer.dto.GetMessageResponseDto;
import com.jose.consumer.service.MessageConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageConsumerListener {
//    @Value("${app.topic}")
//    private String kafkaTopic;

    private final MessageConsumerService messageConsumerService;

    public MessageConsumerListener(MessageConsumerService messageConsumerService) {
        this.messageConsumerService = messageConsumerService;
    }

    @KafkaListener(topics="my-message", groupId = "test-consumer-group1", containerFactory = "customContainerFactory")
    public void recordListener(ConsumerRecord<String, String> record) {
        Gson gson = new Gson();
        GetMessageResponseDto getMessage = gson.fromJson(record.value(), GetMessageResponseDto.class);
        System.out.println(Thread.currentThread().getId());
        messageConsumerService.saveMessage(getMessage.getUsername(), getMessage.getMessage(), getMessage.getSendTime());
    }
}
