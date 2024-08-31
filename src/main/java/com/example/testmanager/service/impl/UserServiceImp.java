package com.example.testmanager.service.impl;

import com.example.testmanager.dto.UserDTO;
import com.example.testmanager.entiity.User;
import com.example.testmanager.respository.UserRepo;
import com.example.testmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepo userRepo;

    @Override
    public void changePass(UserDTO userDTO) {
        Long userId = userDTO.getId();
        String newPassword = userDTO.getPassword();

        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()) {

            User user = userOptional.get();
            user.setPassword(newPassword);
            userRepo.save(user);
            System.out.println("Password changed successfully.");

        } else {

            System.out.println("User not found.");

        }

    }

    @Override
    public void resetPass(Long id, String newPassword) {
    }

    }

