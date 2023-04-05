package com.jose.module1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class Module1 {

    public static void main(String[] args) {
        SpringApplication.run(Module1.class, args);
    }

}
