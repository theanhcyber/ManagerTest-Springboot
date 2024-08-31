package com.example.testmanager.service.impl;

import com.example.testmanager.dto.ExamDTO;
import com.example.testmanager.dto.StudentExamDTO;
import com.example.testmanager.entiity.Exam;
import com.example.testmanager.entiity.StudentExam;
import com.example.testmanager.mapper.Exammaper;
import com.example.testmanager.mapper.StudentExamMapper;
import com.example.testmanager.respository.ExamRepo;
import com.example.testmanager.respository.StudentExamRepo;
import com.example.testmanager.respository.StudentRepo;
import com.example.testmanager.service.StudentExamService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentExamServiceImp implements StudentExamService {
    private final StudentExamMapper studentExamMapper;
    private final Exammaper exammaper;
    private final StudentExamRepo studentExamRepo;
    private final StudentRepo studentRepo;
    private final ExamRepo examRepo;

    @Override
    @Transactional
    public void saveStudentExam(StudentExamDTO studentExamDTO) {

        var studentExam = studentExamDTO.getId() == null ? new StudentExam() : studentExamRepo.findById(studentExamDTO.getId()).orElseThrow();

        var student = studentRepo.findById(studentExamDTO.getStudentId()).orElseThrow();

        List<Exam> allExams = student.getAllExam();

        Exam exam = examRepo.findById(studentExamDTO.getExamId()).orElseThrow();

        int i;
        boolean isValid = true;
        for (i = 0; i < allExams.size(); i++) {
            Exam element = allExams.get(i);
            if (element.getId().equals(exam.getId()) || (!(exam.getStartTime().isAfter(element.getEndTime()) || exam.getEndTime().isBefore(element.getStartTime())))) {
                System.out.println("Register successful");
                isValid = false;
                break;
            }
        }

        if (isValid) {
            studentExam.setStudent(student);
            studentExam.setExam(exam);
            studentExam.setMark(studentExamDTO.getMark());
            studentExam.setTaken(false);
            studentExamMapper.toStudentExamDTO(studentExamRepo.save(studentExam));
        } else {
            System.out.println("Invalid");
        }

    }

    @Override
    public List<ExamDTO> GetUnTakenExamImp(Long studentId, Boolean isTaken) {

        var student = studentRepo.findById(studentId).orElseThrow();

        List<StudentExam> allExams = student.getStudentExam();

        List<ExamDTO> exams = new ArrayList<>();

        for (StudentExam element : allExams) {
            if (isTaken == null) {
                exams.add(exammaper.toExamDTO(element.getExam()));
            } else if (element.isTaken() == isTaken) {
                exams.add(exammaper.toExamDTO(element.getExam()));
            }
        }
        return exams;
    }

    @Override
    @Transactional
    public void savelistStudentExam(List<StudentExamDTO> studentExamDTOS) {
        for(StudentExamDTO element: studentExamDTOS){
            saveStudentExam(element);

        }
    }


}
