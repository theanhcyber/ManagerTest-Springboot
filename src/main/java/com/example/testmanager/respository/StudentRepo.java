package com.example.testmanager.respository;

import com.example.testmanager.entiity.Semester;
import com.example.testmanager.entiity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Long> {
}
