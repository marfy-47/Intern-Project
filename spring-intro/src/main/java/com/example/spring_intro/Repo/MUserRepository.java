package com.example.spring_intro.Repo;

import com.example.spring_intro.Data.Entity.MUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MUserRepository extends JpaRepository<MUser, Long> {
}