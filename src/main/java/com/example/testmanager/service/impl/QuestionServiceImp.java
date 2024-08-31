package com.example.testmanager.service.impl;

import com.example.testmanager.dto.AnswerDTO;
import com.example.testmanager.dto.QuestionDTO;
import com.example.testmanager.entiity.*;
import com.example.testmanager.mapper.QuestionMapper;
import com.example.testmanager.respository.*;
import com.example.testmanager.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class QuestionServiceImp implements QuestionService {
    private final QuestionRepo questionRepo;
    private final QuestionMapper questionMapper;
    private final TopicRepo topicRepo;
    private final AnswerRepo answerRepo;
    @Override
    public void saveQuestion(QuestionDTO questionDTO) {
        var questionId = questionDTO.getId();

        ArrayList<Answer> answers = new ArrayList<>();

        Question question;
        if(questionId == null) {
            question = new Question();
        } else {
            question = questionRepo.findById(questionId).orElseThrow();
        }
        for (AnswerDTO answerDTO : questionDTO.getAnswers()) {
            Answer answer = new Answer();
            answer.setAnswerText(answerDTO.getAnswerText());
            answer.setCorrect(true);
            answers.add(answer);
        }
        var topic = topicRepo.findById(questionDTO.getTopicId()).orElseThrow();
        question.setQuestionText(questionDTO.getQuestionText());
        question.setDifficulty(questionDTO.getDifficulty());
        question.setTopic(topic);
        question.addAnswers(answers);
        questionMapper.toQuestionDTO(questionRepo.save(question));

    }
}
