package com.example.spring_intro.Data.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "blog")
@Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column( columnDefinition = "blog_content")
    private String content;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "user_id")
    private MUser author;

    private Date createdAt;

    private Date updatedAt;

    @OneToMany(mappedBy ="blog", cascade = CascadeType.ALL)
    private List<BlogComment> comment;

    private Double rating;
}