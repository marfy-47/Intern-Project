package org.crud;

import com.example.demo.MUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MUserService {
    // Some Dependencies
    private final org.crud.MUserMapper userMapper;
    private final org.crud.MUserRepository userRepository;

    public MUserService(org.crud.MUserMapper userMapper, org.crud.MUserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public void save(MUserDTO dto) {
        org.crud.MUser entity = userMapper.map(dto);

        // Business Logics
        entity.setMGroup("A");

        // Save into Database
        userRepository.save(entity);
    }

    public ResponseEntity<org.crud.MUser> findById(Long id) {
        Optional<MUser> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(userMapper.map(user.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}