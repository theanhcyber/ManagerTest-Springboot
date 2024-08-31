package com.example.testmanager.mapper;

import com.example.testmanager.dto.StudentClassDTO;
import com.example.testmanager.entiity.StudentClass;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentClassMapper {
    StudentClassDTO toStudentClassTDO(StudentClass studentClass);
}
