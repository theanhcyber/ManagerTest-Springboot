package com.example.testmanager.controller;

import com.example.testmanager.dto.ManagerDTO;
import com.example.testmanager.dto.SemesterDTO;
import com.example.testmanager.service.ManagerService;
import com.example.testmanager.service.SemesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;
    private final SemesterService semesterService;

    @PostMapping(value ="/save-manager")
    public ResponseEntity<Object> saveManager(@RequestBody ManagerDTO managerDTO){
        managerService.saveManager(managerDTO);
        return new ResponseEntity<>("A new manager is created/updated successsfully", HttpStatus.CREATED);
    }

    @PostMapping(value ="/change")
        public ResponseEntity<Object> changeStatus(@RequestBody ManagerDTO managerDTO) {
        managerService.changeStatus(managerDTO.getId());
        return new ResponseEntity<>("A new manager is created/updated successsfully", HttpStatus.CREATED);
    }
        @PostMapping(value ="/save-semester")
        public ResponseEntity<Object> saveSemester(@RequestBody SemesterDTO semesterDTO){
            semesterService.saveSemester(semesterDTO);
            return new ResponseEntity<>("A new semester is created/updated successsfully", HttpStatus.CREATED);

    }
}
