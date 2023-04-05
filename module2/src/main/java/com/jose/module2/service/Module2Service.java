package com.jose.module2.service;

import com.jose.module2.dto.GetUserResponseDto;
import com.jose.module2.entity.User;
import com.jose.module2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Module2Service {
    private final UserRepository userRepository;

    public Module2Service(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String username, String email) {
        userRepository.save(new User(null, username, email));
    }

    public List<GetUserResponseDto> getUser() {
        return userRepository.findAll().stream().map(user-> new GetUserResponseDto(user.getId(), user.getUsername(), user.getEmail()))
                .collect(Collectors.toList());
    }
}
