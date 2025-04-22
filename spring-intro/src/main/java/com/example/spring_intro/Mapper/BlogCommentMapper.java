package com.example.spring_intro.Mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class BlogCommentDTO {


    @JsonProperty("viewer_name")
    private String viewer;

    @JsonProperty("content")
    private String content;
}