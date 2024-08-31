package com.example.testmanager.controller;

import com.example.testmanager.dto.StudentClassDTO;
import com.example.testmanager.dto.SubjectDTO;
import com.example.testmanager.entiity.StudentClass;
import com.example.testmanager.service.StudentClassSevice;
import com.example.testmanager.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentClassController {
    private final StudentClassSevice studentClassSevice;

    @PostMapping(value ="/save-studentClass")
    public ResponseEntity<Object> saveManager(@RequestBody StudentClassDTO studentClassDTO){
        studentClassSevice.saveStudentClass(studentClassDTO);
        return new ResponseEntity<>(" is created/updated successsfully", HttpStatus.CREATED);
    }
}
