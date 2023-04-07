package com.jose.consumer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
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

    public Message() {
    }

    public Message(Long id, String username, String message, String sendTime) {
        this.id = id;
        this.username = username;
        this.message = message;
        this.sendTime = sendTime;
    }
}
