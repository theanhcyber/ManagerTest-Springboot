package com.example.testmanager.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDTO {
    private Long id;

    private String name;

    private Boolean status;

    private Long userId;

    private String code;

    private UserDTO userDto;

}
