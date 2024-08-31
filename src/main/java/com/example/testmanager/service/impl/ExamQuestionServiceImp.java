package com.example.testmanager.service.impl;

import com.example.testmanager.dto.ExamDTO;
import com.example.testmanager.dto.ExamQuestionDTO;
import com.example.testmanager.dto.QuestionDTO;
import com.example.testmanager.entiity.ExamQuestion;
import com.example.testmanager.entiity.Question;
import com.example.testmanager.mapper.ExamQuestionMapper;
import com.example.testmanager.mapper.Exammaper;
import com.example.testmanager.mapper.QuestionMapper;
import com.example.testmanager.respository.ExamQuestionRepo;
import com.example.testmanager.respository.ExamRepo;
import com.example.testmanager.respository.QuestionRepo;
import com.example.testmanager.service.ExamQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamQuestionServiceImp implements ExamQuestionService {
    private final ExamQuestionRepo examQuestionRepo;
    private final ExamRepo examRepo;
    private final QuestionRepo questionRepo;
    private final ExamQuestionMapper examQuestionMapper;
    private final Exammaper exammaper;
    private final QuestionMapper questionMapper;


    @Override
    public void saveExamQuestion(ExamQuestionDTO examQuestionDTO) {

        var examQuestion = examQuestionDTO.getId() == null ? new ExamQuestion() : examQuestionRepo.findById(examQuestionDTO.getId()).orElseThrow();

        var exam = examRepo.findById(examQuestionDTO.getExamId()).orElseThrow();

        var question = questionRepo.findById(examQuestionDTO.getQuestionId()).orElseThrow();

        examQuestion.setQuestion(question);
        examQuestion.setExam(exam);
        examQuestionMapper.toExamQuestion(examQuestionRepo.save(examQuestion));

    }

    @Override
    public ExamDTO GetExam(Long examId) {
        var exam = examRepo.findById(examId).orElseThrow();
        List<ExamQuestion> allExamQuestions = exam.getExamQuestions();

        List<Question> questions = new ArrayList<>();

        for (ExamQuestion element : allExamQuestions) {
            questions.add(element.getQuestion());
        }

        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : questions) {
            questionDTOS.add(questionMapper.toQuestionDTO(question));
        }

        ExamDTO examDTO = exammaper.toExamDTO(exam);

        examDTO.setQuestionDTOS(questionDTOS);

        return examDTO;

    }
}
