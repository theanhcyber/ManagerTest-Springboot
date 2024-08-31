package com.example.testmanager.controller;

import com.example.testmanager.dto.ExamDTO;
import com.example.testmanager.dto.StudentExamDTO;
import com.example.testmanager.service.ExamService;
import com.example.testmanager.service.StudentExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExamController {
    private final ExamService examService;
    private final StudentExamService studentExamService;


    @PostMapping(value ="/save-exam")
    public ResponseEntity<Object> saveManager(@RequestBody ExamDTO examDTO){
        examService.saveExam(examDTO);
        return new ResponseEntity<>("A new exam is created/updated successsfully", HttpStatus.CREATED);
    }

    @PostMapping(value ="/save-Studentexam")
    public ResponseEntity<Object> saveExamStudent(@RequestBody StudentExamDTO studentExamDTO){
        studentExamService.saveStudentExam(studentExamDTO);
        return new ResponseEntity<>("A new exam is created/updated successsfully", HttpStatus.CREATED);
    }



}
