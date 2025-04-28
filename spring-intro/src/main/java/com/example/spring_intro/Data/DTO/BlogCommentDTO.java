package com.example.spring_intro.Data.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.time.LocalDateTime;


@Entity
@Table(name="blog_comment")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserComment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    private String content;
    private String blogName;
    private String author;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "blog")
    private Blog blog;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}