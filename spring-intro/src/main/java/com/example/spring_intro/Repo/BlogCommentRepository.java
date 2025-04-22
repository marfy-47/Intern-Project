package com.example.spring_intro.Repo;
import com.example.spring_intro.Entity.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogCommentRepository extends JpaRepository<BlogComment, Long> {

}

