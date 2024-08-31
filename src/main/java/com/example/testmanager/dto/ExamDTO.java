package com.example.testmanager.dto;

import com.example.testmanager.entiity.ExamQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamDTO {

    private Long id;

    private String name;

    private Float totalScore;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Long subjectId;

    private Long teacherId;

    private String code;

    private List<QuestionDTO> questionDTOS;
}
