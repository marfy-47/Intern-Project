package com.example.spring_intro.Service;

import com.example.spring_intro.Repo.BlogRepository;
import com.example.spring_intro.Data.DTO.Entity.Blog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;


    public Blog save(Blog entity) {
        return blogRepository.save(entity);
    }

    public Blog findById(Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        if (blog.isPresent()) {
            return blog.get();
        } else return null;
    }

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    public Blog update(Blog entity) {
        return blogRepository.save(entity);
    }
}