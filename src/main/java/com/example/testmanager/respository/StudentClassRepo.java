package com.example.testmanager.respository;

import com.example.testmanager.entiity.Semester;
import com.example.testmanager.entiity.StudentClass;
import org.springframework.data.repository.CrudRepository;

public interface StudentClassRepo  extends CrudRepository<StudentClass, Long> {
}
