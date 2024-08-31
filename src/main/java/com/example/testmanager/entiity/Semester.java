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
@Table(name = "semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="start_time")
    private LocalDateTime startTime;

    @Column(name ="end_time")
    private LocalDateTime endTime;

    @Column(name ="code")
    private String code;

    @OneToMany(mappedBy = "semester", fetch = FetchType.LAZY)
    private List<ClassRoom> classRooms;

    @PostPersist
    public void PostPersistSemester() {
        code = String.format("SE%03d", id);
    }

}