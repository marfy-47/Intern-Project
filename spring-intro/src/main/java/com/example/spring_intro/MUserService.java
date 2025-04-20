package com.example.spring_intro;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MUserService {
    // Some Dependencies
    private final com.example.spring_intro.MUserMapper userMapper;
    private final MUserRepository userRepository;

    public MUserService(com.example.spring_intro.MUserMapper userMapper, MUserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public void save(com.example.spring_intro.MUserDTO dto) {
        com.example.spring_intro.MUser entity = userMapper.map(dto);

        entity.setMGroup("A");

        userRepository.save(entity);
    }

    public ResponseEntity<org.spring.intro.MUserDTO> findById(Long id) {
        Optional<org.spring.intro.MUser> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(userMapper.map(user.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void save(org.spring.intro.MUserDTO mUserDTO) {
    }
}