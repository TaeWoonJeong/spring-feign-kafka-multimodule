package com.jose.module1.service;

import com.jose.module1.dto.AddUserRequestDto;
import com.jose.module1.dto.GetUserResponseDto;
import com.jose.module1.service.internal.UserRequestClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Module1Service {
    private final UserRequestClient userRequestClient;

    public Module1Service(UserRequestClient userRequestClient) {
        this.userRequestClient = userRequestClient;
    }

    public void addUser(AddUserRequestDto addUserRequestDto) {
        userRequestClient.addUserRequest(addUserRequestDto);
    }

    public List<GetUserResponseDto> getUser() {
        return userRequestClient.getUserRequest();
    }
}
