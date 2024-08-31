package com.example.testmanager.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamQuestionDTO {
    private Long id;

    private String correctAnswer;

    private Long questionId;

    private Long examId;
}
