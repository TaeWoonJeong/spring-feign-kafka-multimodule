package com.jose.module2.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class Module2Controller {
    private final Environment environment;
    private String uuid = String.valueOf(UUID.randomUUID());

    public Module2Controller(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/info")
    public String getModule2Info() {
        String port = environment.getProperty("local.server.port");
        return "module2의 현재 시간은 "+ LocalDateTime.now().toString() + "이고, 포트는 "+port+"입니다. uuid 값 : "+uuid;
    }

//    @GetMapping("/rolling")
//    fun rolling() : String {
//        return "module2 Rolling Update Completed!"
//    }
}