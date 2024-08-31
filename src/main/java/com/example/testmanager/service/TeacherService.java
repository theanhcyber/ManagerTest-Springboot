package com.example.testmanager.service;

import com.example.testmanager.dto.TeacherDTO;
import org.springframework.web.multipart.MultipartFile;

public interface TeacherService {
    TeacherDTO saveTeacher(TeacherDTO teacherDTO);

    void addQuestionByExcelFile(MultipartFile excel);

    void mark (Long studentId , Long examId);
}
