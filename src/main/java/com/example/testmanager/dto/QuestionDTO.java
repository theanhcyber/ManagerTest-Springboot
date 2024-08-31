package com.example.testmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private Long id;

    private Long topicId;

    private String topicCode;

    private String questionText;

    private Integer difficulty;

    private List<AnswerDTO> answers;

}
