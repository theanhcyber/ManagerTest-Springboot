package com.example.testmanager.entiity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="total_score")
    private Float totalScore;

    @Column(name ="start_time")
    private LocalDateTime startTime;

    @Column(name ="end_time")
    private LocalDateTime endTime;

    @Column(name ="subject_id", insertable = false, updatable = false)
    private Long subjectId;

    @Column(name ="teacher_id", insertable = false, updatable = false)
    private Long teacherId;

    @Column(name ="code")
    private String code;

    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
    private List<ExamQuestion> examQuestions;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
    private List<StudentExam> studentExams;

    @PostPersist
    public void PostPersistExam() {
        code = String.format("EX%03d", id);
    }

    public List<Question> getExam() {
        return examQuestions.stream().map(ExamQuestion::getQuestion).collect(Collectors.toList());
    }

}
