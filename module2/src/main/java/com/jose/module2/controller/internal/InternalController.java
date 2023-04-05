package com.jose.module2.controller.internal;

import com.jose.module2.dto.AddUserRequestDto;
import com.jose.module2.dto.GetUserResponseDto;
import com.jose.module2.service.Module2Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/internal")
@RestController
public class InternalController {
    private final Module2Service module2Service;

    public InternalController(Module2Service module2Service) {
        this.module2Service = module2Service;
    }

    @PostMapping("/addUser")
    public void addUserRequest(@RequestBody AddUserRequestDto addUserRequestDto) {
        module2Service.addUser(addUserRequestDto.getUsername(), addUserRequestDto.getEmail());
    }

    @GetMapping("/getUser")
    List<GetUserResponseDto> getUserRequest() {
        return module2Service.getUser();
    }
}
