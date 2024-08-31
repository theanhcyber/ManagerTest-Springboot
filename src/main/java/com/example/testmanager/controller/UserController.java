package com.example.testmanager.controller;

import com.example.testmanager.dto.ManagerDTO;
import com.example.testmanager.dto.UserDTO;
import com.example.testmanager.service.ManagerService;
import com.example.testmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value ="/change-pass")
    public ResponseEntity<Object> changePass(@RequestBody UserDTO userDTO){
        userService.changePass(userDTO);
        return new ResponseEntity<>("A new pass is updated successsfully", HttpStatus.CREATED);
    }

}
