package com.example.spring_intro.Data.Mapper;
import com.example.spring_intro.Data.DTO.BlogDTO;
import com.example.spring_intro.Data.Entity.Blog;
import org.springframework.stereotype.Component;

@Component
public class BlogMapper {
    public Blog map(BlogDTO dto) {
        Blog blog = new Blog();
        blog.setTitle(dto.getTitle());
        blog.setContent(dto.getContent());
        return blog;
    }
    public BlogDTO map(Blog entity) {
        BlogDTO dto = new BlogDTO();
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        return dto;
    }
}
