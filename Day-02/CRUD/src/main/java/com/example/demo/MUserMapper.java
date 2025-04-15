package com.example.demo;

import com.example.demo.MUserDTO;
import org.crud.MUser;
import org.springframework.stereotype.Component;

@Component
public class MUserMapper {
    public org.crud.MUser map(MUserDTO dto) {
        org.crud.MUser user = new org.crud.MUser();

        // is email valid
        // is this unique
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());

        //
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

    public org.crud.MUser map(MUserDTO dto) {
    }
}