package com.example.testmanager.service.impl;

import com.example.testmanager.dto.StudentAnswerDTO;
import com.example.testmanager.dto.StudentDTO;
import com.example.testmanager.entiity.Answer;
import com.example.testmanager.entiity.Student;
import com.example.testmanager.entiity.StudentExam;
import com.example.testmanager.mapper.StudentExamMapper;
import com.example.testmanager.mapper.StudentMapper;
import com.example.testmanager.mapper.UserMapper;
import com.example.testmanager.respository.ExamRepo;
import com.example.testmanager.respository.StudentExamRepo;
import com.example.testmanager.respository.StudentRepo;
import com.example.testmanager.respository.UserRepo;
import com.example.testmanager.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {
    private final StudentRepo studentRepo;
    private final UserRepo userRepo;
    private final StudentMapper studentMapper;
    private final UserMapper userMapper;
    private final StudentExamMapper studentExamMapper;
    private final StudentExamRepo studentExamRepo;



    @Override
    public void saveStudent(StudentDTO studentDTO) {
        var userDto = studentDTO.getUser();

        var student = studentDTO.getId() == null ? new Student() : studentRepo.findById(studentDTO.getId()).orElseThrow();


        var user = userMapper.toUser(userDto);
        user.setId(student.getUserId() != null ? student.getUserId() : null);
        user.setStatus(true);

        var savedUser = userRepo.save(user);

        student.setName(studentDTO.getName());
        student.setStatus(true);
        student.setUser(savedUser);
        studentMapper.toStudentTDT(studentRepo.save(student));

    }

    @Override
    public void saveStudentAnswer(StudentAnswerDTO studentAnswerDTO) {
        List<StudentAnswerDTO.Answering> answers = studentAnswerDTO.getAnswers();

        var answerList = new ArrayList<String>();
        for (var answer : answers) {
            var str = answer.getQuestionId().toString();
            for (var answerId : answer.getChosenAnswers()) {
                str = str.concat(":").concat(answerId.toString());
            }
            answerList.add(str);
        }
        var result = String.join("|", answerList);

        var studentExam = studentExamRepo.findById(studentAnswerDTO.getExamId()).orElseThrow();
        
        studentExam.setAnswer(result);
        studentExam.setTaken(true);
        studentExamMapper.toStudentExamDTO(studentExamRepo.save(studentExam));
    }
}
