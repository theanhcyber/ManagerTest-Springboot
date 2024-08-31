package com.example.testmanager.entiity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name",nullable = false)
    private String name;

    @Column(name ="status",nullable = false)
    private Boolean status;

    @Column(name ="student_code")
    private String studentCode;

    @Column(name ="user_id",nullable = false, insertable = false, updatable = false)
    private Long userId;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<StudentClass> studentClasses;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<StudentExam> studentExam;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @PostPersist
    public void PostPersistStudent() {
        studentCode = String.format("ST%03d", id);
    }

    public List<Exam> getAllExam() {
        return studentExam.stream().map(StudentExam::getExam).collect(Collectors.toList());
    }

}
