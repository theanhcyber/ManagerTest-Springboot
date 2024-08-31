package com.example.testmanager.mapper;

import com.example.testmanager.dto.UserDTO;
import com.example.testmanager.entiity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDTO userDTO);
}
