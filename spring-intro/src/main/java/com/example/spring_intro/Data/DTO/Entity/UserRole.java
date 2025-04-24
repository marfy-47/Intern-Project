package com.example.spring_intro.Data.DTO.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="role")
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String role;
    @ManyToMany
    @JoinTable(
            name="user_role",
            joinColumns = @JoinColumn(name="role_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    @JsonIgnore
    private Set<MUser> users;

}