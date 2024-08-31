package com.example.testmanager.service.impl;

import com.example.testmanager.dto.ManagerDTO;
import com.example.testmanager.entiity.Manager;
import com.example.testmanager.entiity.User;
import com.example.testmanager.respository.ManagerRepo;
import com.example.testmanager.respository.UserRepo;
import com.example.testmanager.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerServiceImp implements ManagerService {
    private final ManagerRepo managerRepo;
    private final UserRepo userRepo;

    @Override
    public void saveManager(ManagerDTO managerDTO) {
        var managerId = managerDTO.getId();
        var manager = new Manager();
        var user = new User();

        if (managerId != null) {
            manager = managerRepo.findById(managerId).orElseThrow();
            user = manager.getUser();
        }

        var userDto = managerDTO.getUserDto();
        user.setEmail(userDto.getEmail());
        user.setStatus(userDto.getStatus());
        user.setUserName(userDto.getUserName());
        user.setFirstName(userDto.getFirstName());
        user.setMiddleName(userDto.getMiddleName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        var savedUser = userRepo.save(user);

        manager.setCode(managerDTO.getCode());
        manager.setName(managerDTO.getName());
        manager.setStatus(managerDTO.getStatus());
        manager.setUser(savedUser);
        managerRepo.save(manager);
    }
    @Override
    public void changeStatus (Long managerId){
        var manager = managerRepo.findById(managerId).orElseThrow();
        if(manager.getStatus()==true){
            manager.setStatus(false);
        }else{
            manager.setStatus(true);
        }
        managerRepo.save(manager);
    }


}
