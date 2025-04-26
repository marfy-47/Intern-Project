package com.example.spring_intro.Service;

import com.example.spring_intro.Data.DTO.MUserDTO;
import com.example.spring_intro.Data.Entity.MUser;
import com.example.spring_intro.Data.Mapper.MUserMapper;
import com.example.spring_intro.Repo.MUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MUserService {

    private final MUserMapper userMapper;
    private final MUserRepository muserRepository;

    public MUserService(MUserMapper userMapper, MUserRepository muserRepository) {
        this.userMapper = userMapper;
        this.muserRepository = muserRepository;
    }

    public void save(MUserDTO dto) {
        MUser entity = userMapper.map(dto);
        // entity.setMGroup("A"); // Optional business logic
        muserRepository.save(entity);
    }

    public MUser findById(Long id) {
        Optional<MUser> user = muserRepository.findById(id);
        return user.orElse(null);
    }
}
