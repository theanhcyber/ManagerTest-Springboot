package com.example.testmanager.respository;

import com.example.testmanager.entiity.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepo extends CrudRepository<Question, Long> {
}
