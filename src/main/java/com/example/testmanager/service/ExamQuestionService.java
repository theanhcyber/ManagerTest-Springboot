package com.example.testmanager.service;

import com.example.testmanager.dto.ExamDTO;
import com.example.testmanager.dto.ExamQuestionDTO;

public interface ExamQuestionService {
    void saveExamQuestion(ExamQuestionDTO examQuestionDTO);

    ExamDTO GetExam(Long examId ) ;
}
