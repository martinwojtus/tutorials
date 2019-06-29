package com.frontbackend.thymeleaf.users.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.frontbackend.thymeleaf.users.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    public List<User> getUsers() {
        log.info("->>> retrieve users data...");

        return Arrays.asList(User.builder()
                                 .username("test")
                                 .email("test@frontbackend.com")
                                 .build(),
                User.builder()
                    .username("admin")
                    .email("admin@frontbackend.com")
                    .build());
    }
}
