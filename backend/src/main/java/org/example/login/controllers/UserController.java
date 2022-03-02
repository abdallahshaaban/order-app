package org.example.login.controllers;


import org.example.common.exception.LoginException;
import org.example.login.model.User;
import org.example.login.repository.UserRepository;
import org.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.example.common.enums.ResponseCode;

import org.example.login.dto.UserDTO;


@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @PostMapping("user")
    public ResponseEntity<UserDTO> login(@RequestBody User user) {
        try{
            UserDTO userDto = userService.login(user.getName(),user.getPassword());
            return ResponseEntity.status(ResponseCode.SUCCESS.getCode()).body(userDto);

        }catch (LoginException e){
            return new ResponseEntity<>(ResponseCode.UNAUTHORIZED.getHttpStatus());
        }

    }



}