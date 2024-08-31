package com.example.testmanager.service;

import com.example.testmanager.dto.StudentAnswerDTO;
import com.example.testmanager.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    void saveStudent(StudentDTO studentDTO);

    void saveStudentAnswer(StudentAnswerDTO studentAnswerDTO);

}
