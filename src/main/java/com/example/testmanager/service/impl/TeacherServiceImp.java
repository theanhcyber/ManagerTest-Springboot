package com.example.testmanager.service.impl;


import com.example.testmanager.dto.AnswerDTO;
import com.example.testmanager.dto.QuestionDTO;
import com.example.testmanager.dto.TeacherDTO;
import com.example.testmanager.entiity.*;
import com.example.testmanager.mapper.StudentExamMapper;
import com.example.testmanager.mapper.UserMapper;
import com.example.testmanager.respository.*;
import com.example.testmanager.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImp implements TeacherService {
    private final TeacherRepo teacherRepo;
    private final UserRepo userRepo;
    private final SubjectRepo subjectRepo;
    private final UserMapper userMapper;
    private final ExamRepo examRepo;
    private final StudentExamRepo studentExamRepo;
    private final QuestionRepo questionRepo;
    private final StudentExamMapper studentExamMapper;

    @Override
    public TeacherDTO saveTeacher(TeacherDTO teacherDTO) {
        var teacherId = teacherDTO.getId();
        var subjectId = teacherDTO.getSubject().getId();
        var teacher = new Teacher();
        var user = new User();
        Subject subject;

        if (teacherId != null) {
            teacher = teacherRepo.findById(teacherId).orElseThrow();
        } else {

        }

        var userDto = teacherDTO.getUser();
        user = userMapper.toUser(userDto);
        user.setStatus(true);
        var savedUser = userRepo.save(user);

        if (subjectId != null) {
            subject = subjectRepo.findById(subjectId).orElseThrow();
            teacher.setSubject(subject);
        }
        teacher.setName(teacherDTO.getName());
        teacher.setStatus(true);
        teacher.setUser(savedUser);

//      teacherMapper.toTeacherDTO(teacherRepo.save(teacher));
        return teacherDTO;
    }

    @Override
    public void addQuestionByExcelFile(MultipartFile excel) {
        var questions = new ArrayList<QuestionDTO>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(excel.getInputStream());
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);
                var subjectCode = row.getCell(0).getRawValue();
                var topicCode = row.getCell(1).getRawValue();
                var questionText = row.getCell(2).getRawValue();
                var difficulty = row.getCell(3).getRawValue();

                var question = new QuestionDTO();
//                question.setSubjectCode(subjectCode);
                question.setTopicCode(topicCode);
                question.setQuestionText(questionText);
                question.setDifficulty(Integer.parseInt(difficulty));

                var answers = new ArrayList<AnswerDTO>();
                answers.add(new AnswerDTO(row.getCell(4).getRawValue(), row.getCell(5).getRawValue().equals("x")));


                while (questionText.isEmpty()) {
                    answers.add(new AnswerDTO(row.getCell(4).getRawValue(), row.getCell(5).getRawValue().equals("x")));
                }
                question.setAnswers(answers);
                questions.add(question);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void mark(Long studentId, Long examId) {

        var exam = examRepo.findById(examId).orElseThrow();

        List<ExamQuestion> allExamQuestions = exam.getExamQuestions();

        List<Question> questions = new ArrayList<>();
        for (ExamQuestion element : allExamQuestions) {
            questions.add(element.getQuestion());
        }

        int i = 0;
        for (Question question : questions) {
            i++;
        }
        int j = 0;
        for (Question question : questions) {
            for (Answer answer : question.getAnswers()) {
                if (answer.isCorrect()) {
                    j++;
                }
            }

        }
        int countTrueAnswer =0;
        var studentExam = studentExamRepo.findByExamIdAndAndStudentId(examId, studentId).orElseThrow();
        var answerString = studentExam.getAnswer();
        for (String elementAnswer : answerString.split("\\|")) {

            countTrueAnswer += studentMark(elementAnswer);

        }

        Float mark = exam.getTotalScore()/j*countTrueAnswer;


        studentExam.setMark(mark);
        studentExamMapper.toStudentExamDTO(studentExamRepo.save(studentExam));

    }

    private int studentMark(String answerText) {
        String[] answerTextArray = answerText.split(":");
        var questionId = Long.parseLong(answerTextArray[0]);
        var question = questionRepo.findById(questionId).orElseThrow();
        var answerList = question.getAnswers();
        var trueAnswerIdList = answerList.stream().filter(Answer::isCorrect).map(Answer::getId).collect(Collectors.toList());
        var chosenAnswerNumber = answerTextArray.length - 1;

        var countTrueAnswer = 0;
        if (trueAnswerIdList.size() <= chosenAnswerNumber) {
            for(int i = 1; i < answerTextArray.length; i++) {
                var answeredId = Long.parseLong(answerTextArray[i]);
                if (trueAnswerIdList.stream().anyMatch(e -> e.equals(answeredId))) {
                    countTrueAnswer ++;
                }
            }
        }

        return countTrueAnswer;
    }


}

