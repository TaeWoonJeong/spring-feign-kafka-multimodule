package com.jose.producer.dto;

public class SendMessageRequestDto {
    private String username;
    private String message;
    private String sendTime;

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public SendMessageRequestDto() {
    }

    public SendMessageRequestDto(String username, String message) {
        this.username = username;
        this.message = message;
    }
}
