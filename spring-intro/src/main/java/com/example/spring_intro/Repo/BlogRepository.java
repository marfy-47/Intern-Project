package com.example.spring_intro.Repo;

import com.example.spring_intro.Data.DTO.Entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}