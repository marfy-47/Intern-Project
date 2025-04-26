package com.example.spring_intro.Data.Mapper;

import com.example.spring_intro.Data.DTO.MUserDTO;
import com.example.spring_intro.Data.Entity.MUser;
import org.springframework.stereotype.Component;

@Component
public class MUserMapper {

    public MUser map(MUserDTO dto) {
        MUser user = new MUser();

        // Future TODO: validate email format and uniqueness
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPhoneNumber(dto.getPhoneNumber());

        return user;
    }

    public MUserDTO map(MUser entity) {
        MUserDTO dto = new MUserDTO();
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());

        return dto;
    }
}
