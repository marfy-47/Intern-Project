package com.example.spring_intro.Repo;

import com.example.spring_intro.Data.DTO.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
