package com.example.testmanager.respository;

import com.example.testmanager.entiity.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends CrudRepository<Answer, Long> {
}
