package com.example.testmanager.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentExamDTO {
    private Long id;

    private Float mark;

    private boolean isTaken;

    private Long examId;

    private Long studentId;
}
