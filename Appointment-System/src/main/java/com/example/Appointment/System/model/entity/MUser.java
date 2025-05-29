package com.example.Appointment.System.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Email cannot be null")
    @Column(nullable = false)
    private String name;
    private String email;
    @NotNull(message = "Contact cannot be null")
    @Column(nullable = false,unique = true)
    private String contact;
    @NotNull(message = "Password cannot be null")
    @Column(nullable = false)
    private String password;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private  dateOfBirth;
    private Boolean isActive;
    @ManyToMany(mappedBy = "users",fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ToString.Exclude
    private List<UserRole> userRoles

    @OneToOne(mappedBy = "user",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    PatientProfile patientProfile;
    @OneToOne(mappedBy = "user",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    DoctorProfile doctorProfile;

}
