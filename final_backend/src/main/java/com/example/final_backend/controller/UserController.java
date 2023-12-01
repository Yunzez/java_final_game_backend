package com.example.final_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.final_backend.model.User;
import com.example.final_backend.model.UserResponseDto;
import com.example.final_backend.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> loginUser(@Valid @RequestBody User user) {
        User loginUser = userService.loginUser(user);
        UserResponseDto userResponseDto = new UserResponseDto(loginUser.getUsername(), loginUser.getId());
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
        UserResponseDto userResponseDto = new UserResponseDto(user.getUsername(), user.getId());
        return new ResponseEntity<>(userResponseDto,HttpStatus.CREATED);
    }
}
