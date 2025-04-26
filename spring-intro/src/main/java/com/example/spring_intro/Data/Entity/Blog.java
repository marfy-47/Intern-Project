package com.example.spring_intro.Data.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_blog")
@Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "blog_content")
    private String content;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "user_id")
    private MUser author;

    private Date createdAt;

    private Date updatedAt;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BlogComment> comment;

    private Double rating;
}