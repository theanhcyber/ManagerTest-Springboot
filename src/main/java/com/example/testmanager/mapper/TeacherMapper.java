package com.example.testmanager.mapper;

import com.example.testmanager.dto.SubjectDTO;
import com.example.testmanager.dto.TeacherDTO;
import com.example.testmanager.dto.UserDTO;
import com.example.testmanager.entiity.Subject;
import com.example.testmanager.entiity.Teacher;
import com.example.testmanager.entiity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    Teacher toTeacherDTO(TeacherDTO teacherDTO);
    User toUserDTO(UserDTO userDTO);
    Subject toSubjectDTO(SubjectDTO subjectDTO);
}
