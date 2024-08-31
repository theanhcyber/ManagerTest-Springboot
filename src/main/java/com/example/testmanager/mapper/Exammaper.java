package com.example.testmanager.mapper;

import com.example.testmanager.dto.ExamDTO;
import com.example.testmanager.entiity.Exam;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface Exammaper {
    ExamDTO toExamDTO(Exam exam);

}
