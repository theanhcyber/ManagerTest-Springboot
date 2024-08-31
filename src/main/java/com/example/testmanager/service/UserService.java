package com.example.testmanager.service;

import com.example.testmanager.dto.UserDTO;

public interface UserService {
    void changePass(UserDTO userDTO);

    void resetPass(Long id, String newPassword);
}
