package com.example.Appointment.System.Service;

import com.example.Appointment.System.DATA.DTO.UserDTO;
import com.example.Appointment.System.DATA.Entity.MUser;
import com.example.Appointment.System.DATA.Mapper.MUserMapper;
import com.example.Appointment.System.Repo.PatientRepo;
import com.example.Appointment.System.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MUserService {

    private final UserRepo userRepo;
    private final PatientRepo patientRepo;
    private final MUserMapper userMapper;

    public MUser saveUser(MUser user) {
        return userRepo.save(user); // simplified
    }

    public MUser getUserByName(String username) {
        Optional<MUser> user = userRepo.findByName(username);
        return user.orElse(null); // corrected
    }

    public boolean isExitUserById(Long id) {
        return userRepo.existsById(id);
    }

    public MUser updateUser(Long id, UserDTO userDTO) {
        Optional<MUser> userOptional = userRepo.findById(id);
        if (userOptional.isEmpty()) {
            return null;
        }

        MUser user = userOptional.get();
        user.setEmail(userDTO.getEmail());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setGender(userDTO.getGender());
        user.setContact(userDTO.getContact());
        user.setPassword(userDTO.getPassword());

        return userRepo.save(user); // save and return updated user
    }

    public void deleteUser(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        }
    }

    public MUser getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
}
