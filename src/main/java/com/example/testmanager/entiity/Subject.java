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
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="subject_name")
    private String subjectName;

    @Column(name ="code")
    private String code;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<Topic> topics;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<Exam> exams;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<ClassRoom> classRooms;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<Teacher> teachers;

}
