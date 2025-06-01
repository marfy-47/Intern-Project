package com.example.Prescription_generation.Service;


import com.example.Prescription_generation.Model.DTO.UserDTO;
import com.example.Prescription_generation.Model.Entity.User;
import com.example.Prescription_generation.Model.Mapper.UserMapper;
import com.example.Prescription_generation.Repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDTO registerUser(UserDTO userDTO, String rawPassword) {
        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        String encodedPassword = passwordEncoder.encode(rawPassword);
        User user = UserMapper.toEntity(userDTO, encodedPassword);
        User saved = userRepository.save(user);
        return UserMapper.toDTO(saved);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toDTO);
    }

    public UserDetails deleteUser(Long id) {
        userRepository.deleteById(id);
        return null;
    }
}
