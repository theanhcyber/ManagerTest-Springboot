package com.example.testmanager.service.impl;

import com.example.testmanager.dto.ClassRoomDTO;
import com.example.testmanager.entiity.ClassRoom;
import com.example.testmanager.mapper.ClassMapper;
import com.example.testmanager.respository.ClassRoomRepo;
import com.example.testmanager.respository.SemesterRepo;
import com.example.testmanager.respository.SubjectRepo;
import com.example.testmanager.respository.TeacherRepo;
import com.example.testmanager.service.ClassRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ClassRoomServiceImp implements ClassRoomService {
    private final ClassMapper classMapper;
    private final ClassRoomRepo classRoomRepo;
    private final SubjectRepo subjectRepo;
    private final TeacherRepo teacherRepo;
    private final SemesterRepo semesterRepo;

    @Override
    public void saveCLassRoom(ClassRoomDTO classRoomDTO) {

        var timeNow = LocalDateTime.now();

        var classRoom = classRoomDTO.getId() == null ? new ClassRoom() : classRoomRepo.findById(classRoomDTO.getId()).orElseThrow();

        var subject = subjectRepo.findById(classRoomDTO.getSubjectId()).orElseThrow();

        var teacher = teacherRepo.findById(classRoomDTO.getTeacherId()).orElseThrow();

        var semester = semesterRepo.findById(classRoomDTO.getSemesterId()).orElseThrow();

        if (classRoomDTO.getStartTime().isBefore(classRoomDTO.getEndTime()) && !classRoomDTO.getEndTime().isBefore(timeNow)){

         if(!classRoomDTO.getStartTime().isBefore(semester.getStartTime()) && !classRoomDTO.getEndTime().isAfter(semester.getEndTime()))

            classRoom.setName(classRoomDTO.getName());
            classRoom.setStartTime(classRoomDTO.getStartTime());
            classRoom.setEndTime(classRoomDTO.getEndTime());
            classRoom.setTeacher(teacher);
            classRoom.setSubject(subject);
            classRoom.setSemester(semester);
            classMapper.toClass(classRoomRepo.save(classRoom));

        } else {
            System.out.println("Ngày bắt đầu và kết thúc phản nằm trong một kì học");
        }

    }
}
