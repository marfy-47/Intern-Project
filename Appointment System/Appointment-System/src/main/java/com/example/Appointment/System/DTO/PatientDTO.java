package com.example.Appointment.System.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PatientDTO {
    @JsonProperty(value = "patient_name",required = true,defaultValue = "patient_name")
    private String patientName;
    @JsonProperty(value = "mobile_number",required = true,defaultValue = "mobile_number")
    private String mobileNumber;
    private String email;
    private String gender;
    @JsonProperty(value = "date_of_birth")
    private LocalDate dateOfBirth;
    private String password;
    private String role;
    private String profilePictureUrl;
    private String address;

}
