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
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="email",nullable = false)
    private String email;

    @Column(name ="user_name",nullable = false)
    private String userName;

    @Column(name ="first_name",nullable = false)
    private String firstName;

    @Column(name ="middle_name",nullable = false)
    private String middleName;

    @Column(name ="last_name",nullable = false)
    private String lastName;

    @Column(name ="password",nullable = false)
    private String password;

    @Column(name ="status",nullable = false)
    private Boolean status;

    @OneToOne(mappedBy = "user" )
    private Teacher teacher;

    @OneToOne(mappedBy = "user")
    private Manager manager;

    @OneToOne(mappedBy = "user")
    private Student student;

}
