package com.example.testmanager.mapper;

import com.example.testmanager.dto.QuestionDTO;
import com.example.testmanager.entiity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionDTO toQuestionDTO(Question question);
}
