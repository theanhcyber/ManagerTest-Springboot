package com.example.testmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {
    private Long id;

    private String name;

    private String teacherCode;

    private Boolean status ;

    private UserDTO user;

    private SubjectDTO subject;

    private ExamDTO examDTO;

    private TopicDTO topicDTO;

}
