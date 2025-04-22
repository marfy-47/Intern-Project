package com.example.spring_intro.Service;

import com.example.spring_intro.DTO.MUserDTO;
import com.example.spring_intro.Entity.MUser;
import com.example.spring_intro.Repo.MUserRepository;
import com.example.spring_intro.Mapper.MUserMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MUserService {
    // Some Dependencies
    private final MUserMapper userMapper;
    private final MUserRepository userRepository;

    public MUserService(MUserMapper userMapper, MUserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public void save(MUserDTO dto) {
        MUser entity = userMapper.map(dto);

        // Business Logics
        entity.setMGroup("A");

        // Save into Database
        userRepository.save(entity);
    }


    public MUser findById(Long id) {
        Optional<MUser> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
}