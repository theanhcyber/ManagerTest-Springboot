package com.example.testmanager.controller;

import com.example.testmanager.dto.ExamDTO;
import com.example.testmanager.dto.StudentAnswerDTO;
import com.example.testmanager.dto.StudentDTO;
import com.example.testmanager.dto.StudentExamDTO;
import com.example.testmanager.service.StudentExamService;
import com.example.testmanager.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentExamService studentExamService;


    @PostMapping(value = "/save-student")
    public ResponseEntity<Object> saveManager(@RequestBody StudentDTO studentDTO) {
        studentService.saveStudent(studentDTO);
        return new ResponseEntity<>("A new student is created/updated successsfully", HttpStatus.CREATED);
    }

    @GetMapping(value = "/getlist-exam")
    public ResponseEntity<List<ExamDTO>> getlistExam(@RequestParam Long studentId, @RequestParam(required = false) Boolean isTaken) {
        return ResponseEntity.ok(studentExamService.GetUnTakenExamImp(studentId, isTaken));
    }

    @PostMapping(value = "/savelist-exam")
    public ResponseEntity<Object> savelistExam(@RequestBody List<StudentExamDTO> studentExamDTOS) {
        studentExamService.savelistStudentExam(studentExamDTOS);

        return new ResponseEntity<>("Save List StudentExam Successfully", HttpStatus.CREATED);
    }
    @PostMapping(value = "/savelist-answer")
    public ResponseEntity<Object> saveListAnswer(@RequestBody StudentAnswerDTO studentAnswerDTOS) {
        studentService.saveStudentAnswer(studentAnswerDTOS);
        return new ResponseEntity<>("Save List StudentAnswer Successfully", HttpStatus.CREATED);
    }
}
