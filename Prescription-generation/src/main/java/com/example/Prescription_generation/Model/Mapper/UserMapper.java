package com.example.Prescription_generation.Model.Mapper;


import com.example.Prescription_generation.Model.DTO.UserDTO;
import com.example.Prescription_generation.Model.Entity.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        if (user == null) return null;
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        return dto;
    }

    public static User toEntity(UserDTO dto, String encodedPassword) {
        if (dto == null) return null;
        User entity = new User();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setPassword(encodedPassword);
        return entity;
    }
}