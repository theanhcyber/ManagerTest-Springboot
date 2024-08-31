package com.example.testmanager.respository;

import com.example.testmanager.entiity.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepo extends CrudRepository<Topic, Long> {
}
