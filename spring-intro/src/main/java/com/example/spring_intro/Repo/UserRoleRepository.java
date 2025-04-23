package com.example.spring_intro.Repo;
import com.example.spring_intro.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<UserRole,Long> {
}
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo<UserRole> extends JpaRepository<UserRole,Long> {
}