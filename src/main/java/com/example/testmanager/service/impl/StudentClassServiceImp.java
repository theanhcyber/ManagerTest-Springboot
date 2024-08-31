package com.example.testmanager.service.impl;

import com.example.testmanager.dto.StudentClassDTO;
import com.example.testmanager.entiity.ClassRoom;
import com.example.testmanager.entiity.Student;
import com.example.testmanager.entiity.StudentClass;
import com.example.testmanager.entiity.Topic;
import com.example.testmanager.mapper.StudentClassMapper;
import com.example.testmanager.respository.ClassRoomRepo;
import com.example.testmanager.respository.StudentClassRepo;
import com.example.testmanager.respository.StudentRepo;
import com.example.testmanager.service.StudentClassSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentClassServiceImp implements StudentClassSevice {
    private final StudentClassMapper studentClassMapper;
    private final StudentClassRepo studentClassRepo;
    private final StudentRepo studentRepo;
    private final ClassRoomRepo classRoomRepo;
    @Override
    public void saveStudentClass(StudentClassDTO studentClassDTO) {
        var studentClass= studentClassDTO.getId() == null ? new StudentClass() :  studentClassRepo.findById(studentClassDTO.getId()).orElseThrow() ;

        var student = studentRepo.findById(studentClassDTO.getStudentId()).orElseThrow();

        var classRoom = classRoomRepo.findById(studentClassDTO.getClassId()).orElseThrow();

        studentClass.setStudent(student);
        studentClass.setClassRoom(classRoom);
        studentClassMapper.toStudentClassTDO(studentClassRepo.save(studentClass));
    }
}
