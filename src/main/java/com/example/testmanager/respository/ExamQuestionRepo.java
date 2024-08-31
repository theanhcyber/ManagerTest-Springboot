package com.example.testmanager.respository;

import com.example.testmanager.entiity.ExamQuestion;
import org.springframework.data.repository.CrudRepository;

public interface ExamQuestionRepo extends CrudRepository<ExamQuestion, Long> {
}
