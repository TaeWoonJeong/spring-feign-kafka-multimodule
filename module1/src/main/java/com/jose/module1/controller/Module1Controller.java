package com.jose.module1.controller;

import com.jose.module1.dto.AddUserRequestDto;
import com.jose.module1.dto.GetUserResponseDto;
import com.jose.module1.service.Module1Service;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
public class Module1Controller {
    private final Environment environment;
    private final Module1Service module1Service;
    private String uuid = String.valueOf(UUID.randomUUID());

    public Module1Controller(Environment environment, Module1Service module1Service) {
        this.environment = environment;
        this.module1Service = module1Service;
    }

    @GetMapping("/info")
    public String getModule1Info() {
        String port = environment.getProperty("local.server.port");
        return "module1의 현재 시간은 "+ LocalDateTime.now() + "이고, 포트는 "+port+"입니다. uuid 값 : "+uuid;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody AddUserRequestDto addUserRequestDto) {
        module1Service.addUser(addUserRequestDto);
    }

    @GetMapping("/getUser")
    public List<GetUserResponseDto> getUser() {
        return module1Service.getUser();
    }

//    @GetMapping("/rolling")
//    fun rolling() : String {
//        return "module1 Rolling Update Completed!"
//    }
}
