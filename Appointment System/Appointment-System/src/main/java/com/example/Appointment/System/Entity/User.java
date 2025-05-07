package com.example.Appointment.System.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private List<String> degrees=new ArrayList<>();
    @ManyToMany(mappedBy = "users")
    private Set<UserRole> userRoles;
    public static Object getUsername() {
        return null;
    }

    public void setContact(String contact) {
    }
}
