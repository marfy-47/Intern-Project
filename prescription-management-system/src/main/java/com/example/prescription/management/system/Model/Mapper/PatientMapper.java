package com.example.prescription.management.system.Model.Mapper;

import com.example.prescription.management.system.Model.DTO.PatientRegistrationDto;
import com.example.prescription.management.system.Model.Entity.MyUser;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
    public MyUser mapToEntity(PatientRegistrationDto dto) {
        // if +88 is present in phone then that's remove form prefix
        if(dto.getPatientPhone().length()>11) dto.setPatientPhone(dto.getPatientPhone().substring(3));
        MyUser user = new MyUser();
        user.setPhone(dto.getPatientPhone());
        user.setPassword(dto.getPatientPassword());
        user.setName(dto.getPatientName());
        if(dto.getPatientEmail().isEmpty()) dto.setPatientEmail(null);
        user.setEmail(dto.getPatientEmail());
        user.setBirthday(dto.getPatientBirthDate());
        user.setGender(dto.getPatientGender());
        user.setAddress(dto.getPatientAddress());
        user.setDiseaseHistory(dto.getPatientDiseaseHistory());
        return user;
    }
}
