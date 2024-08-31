package com.example.testmanager.entiity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "class")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name",nullable = false)
    private String name;

    @Column(name ="start_time",nullable = false)
    private LocalDateTime startTime;

    @Column(name ="end_time",nullable = false)
    private LocalDateTime endTime;

    @Column(name ="subject_id", insertable = false, updatable = false)
    private Long subjectId;

    @Column(name ="semester_id", insertable = false, updatable = false)
    private Long semesterId;

    @Column(name ="teacher_id", insertable = false, updatable = false)
    private Long teacherId ;

    @Column(name ="code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    @OneToMany(mappedBy = "classRoom", fetch = FetchType.LAZY)
    private List<StudentClass> studentClasses;

    @PostPersist
    public void PostPersistClassRoom() {
        code = String.format("CL%03d", id);
    }
}
