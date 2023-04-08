package com.jose.module1.service.internal;

import com.jose.module1.dto.AddUserRequestDto;
import com.jose.module1.dto.GetUserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "user-request", url = "${server.module2.url}")
public interface UserRequestClient {
    @PostMapping("/internal/addUser")
    void addUserRequest(@RequestBody AddUserRequestDto addUserRequestDto);

    @GetMapping("/internal/getUser")
    List<GetUserResponseDto> getUserRequest();
}