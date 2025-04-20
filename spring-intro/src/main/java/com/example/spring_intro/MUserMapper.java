package com.example.spring_intro;

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

    public com.example.spring_intro.MUserDTO map(org.spring.intro.MUser entity) {
        com.example.spring_intro.MUserDTO dto = new org.spring.intro.MUserDTO();
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        return dto;
    }
}