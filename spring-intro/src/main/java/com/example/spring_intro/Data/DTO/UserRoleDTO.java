package com.example.spring_intro.Data.DTO;

import com.example.spring_intro.Data.Entity.MUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="role")
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class UserRoleDTO {

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
    private String description;


}

