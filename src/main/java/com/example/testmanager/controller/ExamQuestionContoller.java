package com.example.testmanager.controller;

import com.example.testmanager.dto.ExamDTO;
import com.example.testmanager.dto.ExamQuestionDTO;
import com.example.testmanager.dto.QuestionDTO;
import com.example.testmanager.service.ExamQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExamQuestionContoller {

    private final ExamQuestionService examQuestionService;

    @PostMapping(value = "/save-examQuestion")
    public ResponseEntity<Object> save(@RequestBody ExamQuestionDTO examQuestionDTO) {
        examQuestionService.saveExamQuestion(examQuestionDTO);
        return new ResponseEntity<>(" is created/updated successsfully", HttpStatus.CREATED);
    }

    @GetMapping(value = "/getlist-question")
    public ResponseEntity<Object> getlistQuestion(@RequestParam Long examId) {
        return ResponseEntity.ok(examQuestionService.GetExam(examId));
    }
}
