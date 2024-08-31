package com.example.testmanager.mapper;

import com.example.testmanager.entiity.Topic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicMapper {
    Topic totopicDTO(Topic topic);
}
