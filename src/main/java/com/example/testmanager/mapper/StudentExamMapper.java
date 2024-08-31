package com.example.testmanager.mapper;

import com.example.testmanager.dto.StudentExamDTO;
import com.example.testmanager.entiity.StudentExam;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentExamMapper {
    StudentExamDTO toStudentExamDTO(StudentExam studentExam);
}
