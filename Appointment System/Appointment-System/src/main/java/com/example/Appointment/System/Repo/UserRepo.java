package com.example.Appointment.System.Repo;

import com.example.Appointment.System.DATA.Entity.MUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<MUser,Long> {
    Optional<MUser> findByName(String username);
}