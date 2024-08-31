package com.example.testmanager.service.impl;

import com.example.testmanager.dto.ExamDTO;
import com.example.testmanager.entiity.Exam;
import com.example.testmanager.mapper.Exammaper;
import com.example.testmanager.respository.ExamRepo;
import com.example.testmanager.respository.SubjectRepo;
import com.example.testmanager.respository.TeacherRepo;
import com.example.testmanager.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ExamServiceImp implements ExamService {
    private final ExamRepo examRepo;
    private final SubjectRepo subjectRepo;
    private final TeacherRepo teacherRepo;
    private final Exammaper examMaper;

    @Override
    public void saveExam(ExamDTO examDTO) {
        var timeNow = LocalDateTime.now();

        var exam = examDTO.getId() == null ? new Exam() : examRepo.findById(examDTO.getId()).orElseThrow();

        var subject = subjectRepo.findById(examDTO.getSubjectId()).orElseThrow();

        var teacher = teacherRepo.findById(examDTO.getTeacherId()).orElseThrow();

        if (examDTO.getStartTime().isBefore(examDTO.getEndTime())) {

            exam.setName(examDTO.getName());
            exam.setTotalScore(examDTO.getTotalScore());
            exam.setStartTime(examDTO.getStartTime());
            exam.setEndTime(examDTO.getEndTime());
            exam.setTeacher(teacher);
            exam.setSubject(subject);
            examMaper.toExamDTO(examRepo.save(exam));
        } else {
            System.out.println("Ngày bắt đầu và kết thúc phải nằm trong một exams");
        }
    }
}
