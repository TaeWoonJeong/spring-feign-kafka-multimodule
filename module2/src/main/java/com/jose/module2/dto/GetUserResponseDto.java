package com.jose.module2.dto;

public class GetUserResponseDto {
    private Long id;
    private String username;
    private String email;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public GetUserResponseDto() {
    }

    public GetUserResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
