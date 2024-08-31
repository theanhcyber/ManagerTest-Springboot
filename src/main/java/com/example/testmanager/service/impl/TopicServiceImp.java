package com.example.testmanager.service.impl;

import com.example.testmanager.dto.SubjectDTO;
import com.example.testmanager.dto.TopicDTO;
import com.example.testmanager.entiity.*;
import com.example.testmanager.mapper.*;
import com.example.testmanager.respository.SubjectRepo;
import com.example.testmanager.respository.TeacherRepo;
import com.example.testmanager.respository.TopicRepo;
import com.example.testmanager.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicServiceImp implements TopicService {
    private final TopicRepo topicRepo;
    private final TeacherRepo teacherRepo;
    private final SubjectRepo subjectRepo;
    private final TopicMapper topicMapper;


    @Override
    public void saveTopic(TopicDTO topicDTO) {


        var topic= topicDTO.getId() == null ? new Topic() :  topicRepo.findById(topicDTO.getId()).orElseThrow() ;

        var subject = subjectRepo.findById(topicDTO.getSubjectId()).orElseThrow();

        var teacher = teacherRepo.findById(topicDTO.getTeacherId()).orElseThrow();

        topic.setName(topicDTO.getName());
        topic.setTeacher(teacher);
        topic.setSubject(subject);
        topicMapper.totopicDTO(topicRepo.save(topic));

    }
}

