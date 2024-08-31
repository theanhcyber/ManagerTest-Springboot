package com.example.testmanager.respository;

import com.example.testmanager.entiity.Semester;
import com.example.testmanager.entiity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
