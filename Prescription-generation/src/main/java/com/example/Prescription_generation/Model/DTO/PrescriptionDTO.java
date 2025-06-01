package com.example.Prescription_generation.Model.DTO;

import com.example.Prescription_generation.Model.Entity.Max;
import com.example.Prescription_generation.Model.Entity.NotBlank;
import com.example.Prescription_generation.Model.Entity.Prescription;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import java.time.LocalDate;


@Getter
@Setter
@Data
    public class PrescriptionDTO {

        @NotNull
        private LocalDate prescriptionDate;

        @NotBlank
        private String patientName;


        @NotNull
        @Min(value = 0, message = "Age cannot be negative.")
        @Max(value = 120, message = "Age seems too high.")
        private Integer patientAge;

        @NotNull
        private Gender patientGender;

        private String diagnosis;

        private String medicines;

        private LocalDate nextVisitDate;

    public void setPatientGender(Prescription.Gender patientGender) {
    }

    // Enum for Gender
        public enum Gender {
            MALE, FEMALE, OTHER
        }

        // Getters and Setters
        public LocalDate getPrescriptionDate() {
            return prescriptionDate;
        }

        public void setPrescriptionDate(LocalDate prescriptionDate) {
            this.prescriptionDate = prescriptionDate;
        }

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public Integer getPatientAge() {
            return patientAge;
        }

        public void setPatientAge(Integer patientAge) {
            this.patientAge = patientAge;
        }

        public Gender getPatientGender() {
            return patientGender;
        }

        public void setPatientGender(Gender patientGender) {
            this.patientGender = patientGender;
        }

        public String getDiagnosis() {
            return diagnosis;
        }

        public void setDiagnosis(String diagnosis) {
            this.diagnosis = diagnosis;
        }

        public String getMedicines() {
            return medicines;
        }

        public void setMedicines(String medicines) {
            this.medicines = medicines;
        }

        public LocalDate getNextVisitDate() {
            return nextVisitDate;
        }

        public void setNextVisitDate(LocalDate nextVisitDate) {
            this.nextVisitDate = nextVisitDate;
        }

    public static @interface Min {
        String message();

        int value();
    }
}

