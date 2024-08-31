package com.example.testmanager.entiity;

import com.example.testmanager.dto.TeacherDTO;
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
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="subject_id",insertable = false, updatable = false)
    private Long subjectId;

    @Column(name ="teacher_id",insertable = false, updatable = false)
    private Long teacherId;

    @Column(name ="code")
    private String code;

    @OneToMany(mappedBy = "topic", fetch = FetchType.LAZY)
    private List<Question> questions;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @PostPersist
    public void PostPersistTeacher() {code = String.format("TP%03d", id);
    }



}
