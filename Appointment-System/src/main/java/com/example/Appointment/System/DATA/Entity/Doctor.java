package com.example.Appointment.System.DATA.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ Entity
@Table(name = "doctors")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String doctorName;
    private String designation;
    private String licenseNumber;
    private Integer yearsOfExperience;
    private String hospitalOrClinicName;
    private String profilePictureUrl;
    private String languagesSpoken;
    private List<String> degrees=new ArrayList<>();
    private Double rating;
    private Boolean availabilityStatus;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="doctor_vs_date",
            joinColumns = @JoinColumn(name="doctor_id"),
            inverseJoinColumns = @JoinColumn(name="date_id")
    )
    private Set<DoctorAppointmentDate> doctorAppointmentDates=new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER,cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private MUser user;

    @ManyToMany(mappedBy = "doctorProfiles",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Patient> patientProfiles =new HashSet<>();

    @OneToMany(mappedBy = "doctorProfile",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<DoctorBooking> doctorBookings=new HashSet<>();



}
