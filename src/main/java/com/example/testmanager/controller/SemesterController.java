package com.example.testmanager.controller;


import com.example.testmanager.dto.SubjectDTO;
import com.example.testmanager.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SemesterController {
    private final SubjectService subjectService;

    @PostMapping(value ="/saveSubject")
    public ResponseEntity<Object> saveManager(@RequestBody SubjectDTO subjetcDTO){
        subjectService.saveSubject(subjetcDTO);
        return new ResponseEntity<>("A new Subject is created/updated successsfully", HttpStatus.CREATED);
    }
}
