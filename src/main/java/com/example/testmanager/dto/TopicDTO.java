package com.example.testmanager.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopicDTO {
    private Long id;

    private String name;

    private Long subjectId;

    private Long teacherId;

    private String code;

    private TeacherDTO teacher;

    private SubjectDTO subject;


}
