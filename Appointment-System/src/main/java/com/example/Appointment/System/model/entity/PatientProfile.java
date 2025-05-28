package com.example.Appointment.System.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patients")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PatientProfile {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String patientName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.time.LocalDate dateOfBirth;
    private String profilePictureUrl;
    private String address;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private MUser user;

    @ManyToMany
    @JoinTable(name="patient_vs_doctor",
               joinColumns = @JoinColumn(name="patient_id"),
               inverseJoinColumns = @JoinColumn(name="doctor_id"))
    private java.util.Set<DoctorProfile> doctorProfiles = new java.util.HashSet<>();

    @OneToMany(mappedBy = "patientProfile", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private java.util.Set<LabTestBooking> labTestBookings = new java.util.HashSet<>();

    @OneToMany(mappedBy = "patientProfile", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private java.util.Set<DoctorBooking> doctorBookings = new java.util.HashSet<>();
}