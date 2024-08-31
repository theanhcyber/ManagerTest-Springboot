package com.example.testmanager.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;

    private String name;

    private Boolean status;

    private String studentCode;

    private Long userId;

    private UserDTO user;
}
