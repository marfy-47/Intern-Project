package com.example.Appointment.System.Mapper;

import com.example.Appointment.System.DTO.UserDTO;
import com.example.Appointment.System.Entity.Patient;
import com.example.Appointment.System.Entity.User;
import com.example.Appointment.System.Entity.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final PasswordEncoder passwordEncoder;
    public User toUser(UserDTO userDTO) {
        User user= User.builder()
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

    public UserDTO toUserDTO(User mUser) {
        return UserDTO.builder()
                .dateOfBirth(mUser.getDateOfBirth())
                .email(mUser.getEmail())
                .name(mUser.getName())
                .gender(mUser.getGender())
                .build();
    }


}