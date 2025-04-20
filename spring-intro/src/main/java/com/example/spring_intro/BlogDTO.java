package com.example.spring_intro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BlogDTO {
    @JsonProperty(namespace = "blog_title", required = true, defaultValue = "A Title")
    private String title;
    @JsonProperty(namespace = "blog_content", value = "It's about me.", required = true, defaultValue = "The Contents")
    private String content;
    @JsonProperty(namespace = "Author_name", defaultValue ="Author" )
    private String authorName;
    @JsonProperty(namespace = "blog_comment")
    private List comment;
    @JsonProperty(namespace = "create_date")
    private LocalDateTime createdAt;
}