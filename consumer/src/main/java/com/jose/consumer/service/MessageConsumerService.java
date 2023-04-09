package com.jose.consumer.service;

import com.jose.consumer.dto.GetMessageResponseDto;
import com.jose.consumer.entity.Message;
import com.jose.consumer.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageConsumerService {
    private final MessageRepository messageRepository;

    public MessageConsumerService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void saveMessage(String username, String message, String sendTime) {
        messageRepository.save(new Message(null, username, message, sendTime));
    }

    public List<GetMessageResponseDto> getRecentMessages() {
        return messageRepository.findTop10ByOrderByIdDesc().stream().map(message-> new GetMessageResponseDto(message.getId(), message.getUsername(), message.getMessage(), message.getSendTime()))
                .collect(Collectors.toList());
    }
}
