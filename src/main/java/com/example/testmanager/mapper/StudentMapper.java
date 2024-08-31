package com.example.testmanager.mapper;

import com.example.testmanager.dto.StudentDTO;
import com.example.testmanager.entiity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toStudentTDT(Student student);
}
