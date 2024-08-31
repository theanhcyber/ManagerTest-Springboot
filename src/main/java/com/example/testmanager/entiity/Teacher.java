package com.example.testmanager.entiity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="teacher_code")
    private String teacherCode;

    @Column(name ="status",nullable = false)
    private Boolean status ;

    @Column(name ="subject_id", insertable = false, updatable = false)
    private Long subjectId ;

    @Column(name ="user_id",nullable = false, insertable = false, updatable = false)
    private Long userId ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<Exam> exam;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<ClassRoom> classRooms;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<Topic> topics;

    @PostPersist
    public void PostPersistTeacher() {
        teacherCode = String.format("TC%03d", id);
    }
}
