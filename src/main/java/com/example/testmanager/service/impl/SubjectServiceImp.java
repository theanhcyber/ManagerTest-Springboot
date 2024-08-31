package com.example.testmanager.service.impl;

import com.example.testmanager.dto.SubjectDTO;
import com.example.testmanager.entiity.Subject;
import com.example.testmanager.respository.SubjectRepo;
import com.example.testmanager.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectServiceImp implements SubjectService {
    private final SubjectRepo subjectRepo;
    @Override
    public void saveSubject(SubjectDTO subjectDto) {
        var SubjectId = subjectDto.getId();
        Subject subject;
        if(SubjectId == null) {
            subject = new Subject();
        } else {
            subject = subjectRepo.findById(SubjectId).orElseThrow();
        }
        subject.setSubjectName(subjectDto.getSubjectName());
        subject.setCode(subjectDto.getCode());
        subjectRepo.save(subject);

    }
}
