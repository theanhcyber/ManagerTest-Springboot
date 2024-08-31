package com.example.testmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcelDataDTO {
    private String Code;
    private String Topic;
    private String Questions;
    private List Answers;
    private List correctAnswer;
}
