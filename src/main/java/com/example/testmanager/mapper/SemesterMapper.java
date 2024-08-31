package com.example.testmanager.mapper;

import com.example.testmanager.dto.StudentDTO;
import com.example.testmanager.entiity.Semester;
import com.example.testmanager.entiity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SemesterMapper {
    Semester toSemesterDTO(Semester semester);
}
