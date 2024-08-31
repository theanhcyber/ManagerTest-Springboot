package com.example.testmanager.respository;

import com.example.testmanager.entiity.Semester;
import org.springframework.data.repository.CrudRepository;

public interface SemesterRepo extends CrudRepository<Semester, Long> {
}
