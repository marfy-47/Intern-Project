package com.example.Appointment.System.DATA.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String doctorName;
    private String designation;
    private String contactNumber;
    private String email;
    private Integer yearsOfExperience;
    private String hospitalOrClinicName;
    private String address;
    private String profilePictureUrl;
    private String languagesSpoken;
    private List<String> degrees=new ArrayList<>();
    private Double rating;
    private String gender;
    private String password;
    private String  licenseNumber;
    private Boolean availabilityStatus;
    private String role;



    @ManyToMany(mappedBy = "doctors",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Patient> patients=new HashSet<>();
    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<DoctorBooking> doctorBookings=new HashSet<>();
    public void setPatient(Set<Patient> patients) {
        this.patients = patients;
    }

}
