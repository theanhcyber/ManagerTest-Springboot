package com.example.testmanager.service;

import com.example.testmanager.dto.ManagerDTO;

public interface ManagerService {

    void saveManager(ManagerDTO managerDTO);

    void changeStatus(Long managerId);

}
