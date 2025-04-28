package com.example.spring_intro.Data.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
@Data
public class MUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(nullable = false, name = "user_id")
        private Blog author;

        private Date createdAt;

        private Date updatedAt;

        @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
        private List<BlogComment> comment;

        private Double rating;
    }
