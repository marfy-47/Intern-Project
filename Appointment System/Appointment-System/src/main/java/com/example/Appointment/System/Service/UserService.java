package com.example.Appointment.System.Service;

import com.example.Appointment.System.DTO.UserDTO;
import com.example.Appointment.System.Entity.User;
import com.example.Appointment.System.Mapper.UserMapper;
import com.example.Appointment.System.Repo.PatientRepo;
import com.example.Appointment.System.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final PatientRepo patientRepo;
    private final UserMapper userMapper;

    public User saveUser(User user) {
        return userRepo.save(user); // simplified
    }

    public User getUserByName(String username) {
        Optional<User> user = userRepo.findByName(username);
        return user.orElse(null); // corrected
    }

    public boolean isExitUserById(Long id) {
        return userRepo.existsById(id);
    }

    public User updateUser(Long id, UserDTO userDTO) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isEmpty()) {
            return null;
        }

        User user = userOptional.get();
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

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
}
