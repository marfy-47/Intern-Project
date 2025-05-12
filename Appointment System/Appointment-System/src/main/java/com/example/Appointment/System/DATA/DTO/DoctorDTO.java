package com.example.Appointment.System.DATA.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DoctorDTO {
    private String doctorName;
    private String designation;
    private String contactNumber;
    private String email;
    private Integer yearsOfExperience;
    private String licenseNumber;
    private String hospitalOrClinicName;
    private String address;
    private String languagesSpoken;
    private List<String> degrees;
    private String gender;
    private Boolean availabilityStatus;
    private String profilePictureUrl;
    private Double rating;
    private String password;

}