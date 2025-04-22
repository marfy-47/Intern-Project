package com.example.spring_intro.Mapper;

import com.example.spring_intro.DTO.MUserDTO;
import org.springframework.stereotype.Component;

@Component
public class MUserMapper {
    public org.spring.intro.MUser map(org.spring.intro.MUserDTO dto) {
        org.spring.intro.MUser user = new org.spring.intro.MUser();

        // is email valid
        // is this unique
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());

        //
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }

    public MUserDTO map(org.spring.intro.MUser entity) {
        MUserDTO dto = new org.spring.intro.MUserDTO();
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        return dto;
    }
}