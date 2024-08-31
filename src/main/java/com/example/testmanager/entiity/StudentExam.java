package com.example.testmanager.entiity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_exam")
public class StudentExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="mark")
    private Float mark;

    @Column(name ="is_taken")
    private boolean isTaken;

    @Column(name ="answer")
    private String answer;

    @Column(name ="exam_id", insertable = false, updatable = false)
    private Long examId;

    @Column(name ="student_id", insertable = false, updatable = false)
    private Long studentId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

}
