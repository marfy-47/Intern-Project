package com.example.spring_intro.Repo;
import com.example.spring_intro.Data.DTO.Entity.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogCommentRepository extends JpaRepository<BlogComment, Long> {

}

