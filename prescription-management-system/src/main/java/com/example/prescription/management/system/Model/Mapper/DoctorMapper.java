package com.example.prescription.management.system.Model.Mapper;

import com.example.prescription.management.system.Model.DTO.DoctorRegistrationDto;
import com.example.prescription.management.system.Model.Entity.MyUser;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
    public MyUser mapToEntity(DoctorRegistrationDto dto)
    {
        // if +88 is present in phone then that's remove form prefix
        if(dto.getDoctorPhone().length()>11) dto.setDoctorPhone(dto.getDoctorPhone().substring(3));
        MyUser user = new MyUser();
        user.setPhone(dto.getDoctorPhone());
        user.setPassword(dto.getPassword());
        user.setName(dto.getDoctorName());
        if(dto.getDoctorEmail().isEmpty()) dto.setDoctorEmail(null);
        user.setEmail(dto.getDoctorEmail());
        user.setBirthday(dto.getDateOfBirth());
        user.setGender(dto.getDoctorGender());
        user.setAddress(dto.getDoctorAddress());
        user.setSpecialization(dto.getSpecialization());
        user.setExperience(dto.getExperience());
        user.setQualification(dto.getQualification());

        return user;
    }

    public DoctorRegistrationDto mapToDTO(MyUser doctor) {
        DoctorRegistrationDto dto = new DoctorRegistrationDto();
        dto.setDoctorPhone(doctor.getPhone());
        dto.setDoctorName(doctor.getName());
        dto.setDoctorEmail(doctor.getEmail());
        dto.setDoctorGender(doctor.getGender());
        dto.setDoctorAddress(doctor.getAddress());
        dto.setSpecialization(doctor.getSpecialization());
        dto.setExperience(doctor.getExperience());
        dto.setQualification(doctor.getQualification());
        return dto;
    }
}
