package com.jose.consumer.dto;

public class GetMessageResponseDto {
    private Long id;
    private String username;
    private String message;
    private String sendTime;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public String getSendTime() {
        return sendTime;
    }

    public GetMessageResponseDto(Long id, String username, String message, String sendTime) {
        this.id = id;
        this.username = username;
        this.message = message;
        this.sendTime = sendTime;
    }
}
