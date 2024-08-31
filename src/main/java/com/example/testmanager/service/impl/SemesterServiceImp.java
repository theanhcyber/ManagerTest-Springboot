package com.example.testmanager.service.impl;

import com.example.testmanager.dto.SemesterDTO;
import com.example.testmanager.entiity.Semester;
import com.example.testmanager.mapper.SemesterMapper;
import com.example.testmanager.respository.SemesterRepo;
import com.example.testmanager.service.SemesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SemesterServiceImp implements SemesterService {
    private final SemesterRepo semesterRepo;
    private final SemesterMapper semesterMapper;

    @Override
    public void saveSemester(SemesterDTO semesterDTO) {
        var timeNow = LocalDateTime.now();
        var semester = semesterDTO.getId() == null ? new Semester() : semesterRepo.findById(semesterDTO.getId()).orElseThrow();
        if (semesterDTO.getStartTime().isBefore(semesterDTO.getEndTime()) && !semesterDTO.getEndTime().isBefore(timeNow)) {
            List<Semester> allSemesters = (List<Semester>) semesterRepo.findAll();
            boolean isOverlapping = false;

            for (Semester s : allSemesters) {
                if ((semesterDTO.getStartTime().isBefore(s.getEndTime()) && semesterDTO.getEndTime().isAfter(s.getStartTime())) || (semesterDTO.getStartTime().isEqual(s.getEndTime()) || semesterDTO.getEndTime().isEqual(s.getStartTime()))) {
                    isOverlapping = true;
                    break;
                }
            }
            if (!isOverlapping) {
                semester.setName(semesterDTO.getName());
                semester.setStartTime(semesterDTO.getStartTime());
                semester.setEndTime(semesterDTO.getEndTime());
                semesterMapper.toSemesterDTO(semesterRepo.save(semester));
            } else {
                System.out.println("Ngày bắt đầu phải trước ngày kết thúc và ngày kết thúc hiện tại hoặc tương lai ");
            }
        } else {
            System.out.println("Overlaping ");
        }
    }
}
