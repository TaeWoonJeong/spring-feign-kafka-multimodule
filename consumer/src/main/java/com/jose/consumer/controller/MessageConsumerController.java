package com.jose.consumer.controller;

import com.jose.consumer.dto.GetMessageResponseDto;
import com.jose.consumer.service.MessageConsumerService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequestMapping("/consumer")
@RestController
public class MessageConsumerController {
    private final Environment environment;
    private final MessageConsumerService messageConsumerService;

    private String uuid = String.valueOf(UUID.randomUUID());

    public MessageConsumerController(Environment environment, MessageConsumerService messageConsumerService) {
        this.environment = environment;
        this.messageConsumerService = messageConsumerService;
    }

    @GetMapping("/info")
    public String getModule1Info() {
        String port = environment.getProperty("local.server.port");
        return "message-consumer 의 현재 시간은 "+ LocalDateTime.now() + "이고, 포트는 "+port+"입니다. uuid 값 : "+uuid;
    }

    @GetMapping("/getRecentMessages")
    public List<GetMessageResponseDto> getRecentMessages() {
        return messageConsumerService.getRecentMessages();
    }
}
