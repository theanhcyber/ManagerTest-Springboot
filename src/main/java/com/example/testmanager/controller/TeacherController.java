package com.example.testmanager.controller;

import com.example.testmanager.dto.ClassRoomDTO;
import com.example.testmanager.dto.ExcelDataDTO;
import com.example.testmanager.dto.TeacherDTO;
import com.example.testmanager.service.ClassRoomService;
import com.example.testmanager.service.StudentExamService;
import com.example.testmanager.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final ClassRoomService classRoomService;
    private final StudentExamService studentExamService;

    @PostMapping(value ="/save-teacher")
    public ResponseEntity<Object> saveTeacher(@RequestBody TeacherDTO teacherDTO ){

        return ResponseEntity.ok(teacherService.saveTeacher(teacherDTO));
    }

    @PostMapping(value ="/save-class")
    public ResponseEntity<Object> saveClass(@RequestBody ClassRoomDTO classRoomDTO ){
//        classRoomService.(classRoomDTO);
        return new ResponseEntity<>("A new class is created/updated successsfully", HttpStatus.CREATED);
    }

    @PostMapping("/save-excel")
    public void excelReader(@RequestParam("file") MultipartFile excel) {
        teacherService.addQuestionByExcelFile(excel);
    }

    @PostMapping(value ="/save-mark")
    public ResponseEntity<Object> saveMark(@RequestParam Long studentId, Long examId ){
        teacherService.mark(studentId,examId);
        return new ResponseEntity<>("Mark is updated successsfully", HttpStatus.CREATED);
    }
    private boolean isCellMerged(XSSFSheet sheet, int rowIdx, int colIdx) {
        for (CellRangeAddress mergedRegion : sheet.getMergedRegions()) {
            if (rowIdx >= mergedRegion.getFirstRow() && rowIdx <= mergedRegion.getLastRow() &&
                    colIdx >= mergedRegion.getFirstColumn() && colIdx <= mergedRegion.getLastColumn()) {
                return true;
            }
        }
        return false;
    }

    private String getMergedCellValue(XSSFSheet sheet, int rowIdx, int colIdx) {
        for (CellRangeAddress mergedRegion : sheet.getMergedRegions()) {
            DataFormatter dataFormatter = new DataFormatter();
            if (rowIdx >= mergedRegion.getFirstRow() && rowIdx <= mergedRegion.getLastRow() &&
                    colIdx >= mergedRegion.getFirstColumn() && colIdx <= mergedRegion.getLastColumn()) {
                XSSFRow mergedRow = sheet.getRow(mergedRegion.getFirstRow());
                XSSFCell mergedCell = mergedRow.getCell(mergedRegion.getFirstColumn());
                return dataFormatter.formatCellValue(mergedCell);
            }
        }
        return null;
    }

}
