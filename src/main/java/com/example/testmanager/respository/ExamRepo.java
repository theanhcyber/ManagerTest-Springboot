package com.example.testmanager.respository;

import com.example.testmanager.entiity.Exam;
import org.springframework.data.repository.CrudRepository;

public interface ExamRepo extends CrudRepository<Exam, Long> {
}
