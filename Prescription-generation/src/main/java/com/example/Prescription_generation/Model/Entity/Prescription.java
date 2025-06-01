package com.example.Prescription_generation.Model.Entity;

import com.example.Prescription_generation.Model.DTO.PrescriptionDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Table(name="prescription")
@Getter
@Setter
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate prescriptionDate;

    @NotBlank
    private String patientName;

    @NotNull
    @PrescriptionDTO.Min(value = 0, message = "Age cannot be negative.")
    @Max(value = 120, message = "Age seems too high.")
    private Integer patientAge;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender patientGender;

    @Lob
    private String diagnosis;

    @Lob
    private String medicines;

    private LocalDate nextVisitDate;

    public void setPatientGender
            (PrescriptionDTO.Gender patientGender) {
    }

    public enum Gender {
        MALE, FEMALE, OTHER
    }
}
