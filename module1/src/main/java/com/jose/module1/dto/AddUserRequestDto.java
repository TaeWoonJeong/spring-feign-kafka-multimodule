package com.jose.module1.dto;

public class AddUserRequestDto {
    private String username;
    private String email;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public AddUserRequestDto() {
    }

    public AddUserRequestDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
