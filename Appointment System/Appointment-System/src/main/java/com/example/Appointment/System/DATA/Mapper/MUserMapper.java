package com.example.Appointment.System.DATA.Mapper;

import com.example.Appointment.System.DATA.DTO.UserDTO;
import com.example.Appointment.System.DATA.Entity.Patient;
import com.example.Appointment.System.DATA.Entity.MUser;
import com.example.Appointment.System.DATA.Entity.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class MUserMapper {
    private final PasswordEncoder passwordEncoder;
    public MUser toUser(UserDTO userDTO) {
        MUser user= MUser.builder()
                .email(userDTO.getEmail())
                .dateOfBirth(userDTO.getDateOfBirth())
                .gender(userDTO.getGender())
                .name(userDTO.getName())
                .isActive(false)
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .build();
        UserRole userRole=new UserRole();
        userRole.setRole("PATIENT");
        userRole.setUsers(Set.of(user));
        user.setUserRoles(Set.of(userRole));
        Patient patientProfile=new Patient();
        patientProfile.setDateOfBirth(user.getDateOfBirth());
        patientProfile.setPatientName(user.getName());
        patientProfile.setUser(user);
        user.setPatient(patientProfile);
        return user;
    }

    public UserDTO toUserDTO(MUser mUser) {
        return UserDTO.builder()
                .dateOfBirth(mUser.getDateOfBirth())
                .email(mUser.getEmail())
                .name(mUser.getName())
                .gender(mUser.getGender())
                .build();
    }


}