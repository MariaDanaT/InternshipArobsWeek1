package com.example.musify.mapper;

import com.example.musify.dto.userdto.RegisterUserDTO;
import com.example.musify.dto.userdto.UserViewDTO;
import com.example.musify.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "firstName", expression = "java(userViewDTO.getFullName().split(\" \")[0])")
    @Mapping(target = "lastName", expression = "java(userViewDTO.getFullName().split(\" \")[1])")
    User userDTOToUser(UserViewDTO userViewDTO);

    @Mapping(target = "fullName", expression = "java(user.getFirstName() +\" \"+ user.getLastName())")
    UserViewDTO userDTOFromUser(User user);

    @Mapping(target = "role", expression = "java(\"regular\")")
    User registerUserDTOToUser(RegisterUserDTO registerUserDTO);
    @Mapping(target = "confirmPassword", expression = "java(user.getPassword())")
    RegisterUserDTO userToRegisterUserDTO(User user);

}
