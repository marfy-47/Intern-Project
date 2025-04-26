package com.example.spring_intro.Data.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_comments")
public class BlogComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private MUser viewer;

    @Column(nullable = false)
    private String content;

}