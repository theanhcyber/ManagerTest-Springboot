package com.example.testmanager.mapper;

import com.example.testmanager.entiity.Exam;
import com.example.testmanager.entiity.ExamQuestion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamQuestionMapper {
    ExamQuestion toExamQuestion(ExamQuestion examQuestion);
}
