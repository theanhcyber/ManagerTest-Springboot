package com.example.testmanager.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentAnswerDTO {
    private Long examId;
    private List<Answering> answers;

    @Data
    public static class Answering {
        private Long questionId;
        private List<Long> chosenAnswers;
    }
}
