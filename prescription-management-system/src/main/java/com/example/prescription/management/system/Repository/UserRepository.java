package com.example.prescription.management.system.Repository;


import com.example.prescription.management.system.Model.Entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByPhone(String phone);
    Optional<MyUser> findByEmail(String email);
}
