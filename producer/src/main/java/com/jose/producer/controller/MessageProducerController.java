package com.jose.producer.controller;

import com.google.gson.Gson;
import com.jose.producer.dto.SendMessageRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RequestMapping("/producer")
@RestController
public class MessageProducerController {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Environment environment;
    private String uuid = String.valueOf(UUID.randomUUID());

    @Value("${app.topic}")
    private String kafkaTopic;

    public MessageProducerController(KafkaTemplate<String, String> kafkaTemplate, Environment environment) {
        this.kafkaTemplate = kafkaTemplate;
        this.environment = environment;
    }

    @GetMapping("/info")
    public String getModule1Info() {
        String port = environment.getProperty("local.server.port");
        return "message-producer 의 현재 시간은 "+ LocalDateTime.now() + "이고, 포트는 "+port+"입니다. uuid 값 : "+uuid;
    }

    @PostMapping("/send")
    public void send(@RequestBody SendMessageRequestDto sendMessageRequestDto) {
        sendMessageRequestDto.setSendTime(LocalDateTime.now().toString());
        Gson gson = new Gson();
        String jsonMessageLog = gson.toJson(sendMessageRequestDto);
        System.out.println(jsonMessageLog);

        kafkaTemplate.send(kafkaTopic, jsonMessageLog).addCallback(
                new ListenableFutureCallback<SendResult<String, String>>() {
                    @Override
                    public void onSuccess(SendResult<String, String> result) {
                        System.out.println("성공");
                    }

                    @Override
                    public void onFailure(Throwable ex) {
                        System.out.println("실패");
                    }
                }
        );
    }
}
