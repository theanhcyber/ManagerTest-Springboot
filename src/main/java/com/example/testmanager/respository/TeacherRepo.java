package com.example.testmanager.respository;

import com.example.testmanager.entiity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepo  extends CrudRepository<Teacher, Long> {
}
