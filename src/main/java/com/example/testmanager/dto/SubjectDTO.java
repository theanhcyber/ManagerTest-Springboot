package com.example.testmanager.dto;

import com.example.testmanager.entiity.ClassRoom;
import com.example.testmanager.entiity.Exam;
import com.example.testmanager.entiity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {

    private Long id;

    private String subjectName;

    private String code;


}
