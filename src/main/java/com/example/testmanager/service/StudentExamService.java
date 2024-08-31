package com.example.testmanager.service;

import com.example.testmanager.dto.ExamDTO;
import com.example.testmanager.dto.StudentExamDTO;

import java.util.List;

public interface StudentExamService {
    void saveStudentExam(StudentExamDTO studentExamDTO) ;
    List<ExamDTO> GetUnTakenExamImp(Long studentId , Boolean isTaken) ;

    void savelistStudentExam(List<StudentExamDTO> studentExamDTOS);



}
