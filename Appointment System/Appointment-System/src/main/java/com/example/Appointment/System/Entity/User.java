package com.example.Appointment.System.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private Long contactNo;

    private String gender;
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private String profession;
    private String specialization;
    private Integer yearsOfExperience;
    private String hospitalOrClinicName;
    private Boolean availabilityStatus;
    private String address;
    private double rating;
    private String role;
    private String profilePictureUrl;

    @ElementCollection
    private List<String> degrees = new ArrayList<>();

    @ManyToMany(mappedBy = "users", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Patient patientProfile;
}
