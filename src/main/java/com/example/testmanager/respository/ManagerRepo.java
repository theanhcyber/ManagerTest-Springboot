package com.example.testmanager.respository;

import com.example.testmanager.entiity.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepo extends CrudRepository<Manager, Long> {
}
