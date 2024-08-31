package com.example.testmanager.controller;

import com.example.testmanager.dto.ManagerDTO;
import com.example.testmanager.dto.QuestionDTO;
import com.example.testmanager.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping(value ="/save-question")
    public ResponseEntity<Object> saveManager(@RequestBody QuestionDTO questionDTO){
        questionService.saveQuestion(questionDTO);
        return new ResponseEntity<>("A new manager is created/updated successsfully", HttpStatus.CREATED);
    }

}
