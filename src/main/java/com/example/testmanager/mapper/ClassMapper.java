package com.example.testmanager.mapper;

import com.example.testmanager.entiity.ClassRoom;
import com.example.testmanager.entiity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassMapper {
    ClassRoom toClass(ClassRoom classRoom);
}
