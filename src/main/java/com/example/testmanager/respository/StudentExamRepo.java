package com.example.testmanager.respository;

import com.example.testmanager.entiity.StudentExam;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentExamRepo extends CrudRepository<StudentExam, Long> {
    Optional<StudentExam> findByExamIdAndAndStudentId(Long examId, Long studentId);
}
