package com.example.Appointment.System.DATA.Mapper;

import com.example.Appointment.System.DATA.DTO.DoctorDTO;
import com.example.Appointment.System.DATA.Entity.Doctor;
import com.example.Appointment.System.DATA.Entity.MUser;
import com.example.Appointment.System.DATA.Entity.UserRole;
import com.example.Appointment.System.Repo.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DoctorMapper {
//    private final PasswordEncoder passwordEncoder;
    private final DoctorRepo doctorRepo;
    public Doctor toDoctor(DoctorDTO doctorDTO) {
        Doctor doctorProfile= Doctor.builder()
                .languagesSpoken(doctorDTO.getLanguagesSpoken())
                .yearsOfExperience(doctorDTO.getYearsOfExperience())
                .designation(doctorDTO.getDesignation())
                .hospitalOrClinicName(doctorDTO.getHospitalOrClinicName())
                .availabilityStatus(doctorDTO.getAvailabilityStatus())
                .degrees(doctorDTO.getDegrees())
                .doctorName(doctorDTO.getDoctorName())
                .build();
        MUser mUser=MUser.builder()
                .email(doctorDTO.getEmail())
                .isActive(false)
//                .password(passwordEncoder.encode(doctorDTO.getPassword()))
                .name(doctorDTO.getDoctorName())
                .gender(doctorDTO.getGender())
                .doctor(doctorProfile)
                .build();
        UserRole userRole= UserRole.builder()
                .role("DOCTOR")
                .users(Set.of(mUser))
                .build();
        mUser.setUserRoles(Set.of(userRole));
        doctorProfile.setUser(mUser);
        return doctorProfile;
    }

    public DoctorDTO toDoctorDTO(Doctor doctorProfile) {
        return DoctorDTO.builder()
                .languagesSpoken(doctorProfile.getLanguagesSpoken())
                .yearsOfExperience(doctorProfile.getYearsOfExperience())
                .designation(doctorProfile.getDesignation())
                .hospitalOrClinicName(doctorProfile.getHospitalOrClinicName())
                .availabilityStatus(doctorProfile.getAvailabilityStatus())
                .degrees(doctorProfile.getDegrees())
                .build();
    }

    public List<DoctorDTO> toDoctorDTOs(List<Doctor> all) {
        List<DoctorDTO>doctorDTOS=new ArrayList<>();
        for (Doctor doctorProfile :all){
            doctorDTOS.add(toDoctorDTO(doctorProfile));
        }
        return doctorDTOS;
    }
}