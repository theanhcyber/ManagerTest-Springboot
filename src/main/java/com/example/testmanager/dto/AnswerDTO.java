package com.example.testmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {
    private Long id;

    private boolean isCorrect;

    private String answerText;

    private Long questionId;

    public AnswerDTO(String answerText, Boolean isCorrect) {
        this.isCorrect = isCorrect;
        this.answerText = answerText;
    }
}
