package com.example.testmanager.mapper;

import com.example.testmanager.dto.SubjectDTO;
import com.example.testmanager.entiity.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    Subject toSubjectDTO (SubjectDTO subjectDTO);
}
