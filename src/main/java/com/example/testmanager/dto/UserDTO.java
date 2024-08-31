package com.example.testmanager.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private Long id;

    private String email;

    private String userName;

    private String firstName;

    private String middleName;

    private String lastName;

    private String password;

    private Boolean status;

}
