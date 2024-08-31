package com.example.testmanager.respository;

import com.example.testmanager.entiity.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepo extends CrudRepository<Subject, Long> {
}
