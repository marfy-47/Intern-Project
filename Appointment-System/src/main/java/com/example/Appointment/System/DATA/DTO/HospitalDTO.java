package com.example.Appointment.System.DATA.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalDTO {
    private String hospitalName;
    private String country;
    private String city;
    private String zipCode;
    private String address;
    private String roadNo;
    private String holdingNo;
    private String profilePictureUrl;
    private String contactNumber;
    private String email;
    private String operatingHours;
    private String accreditation;
    private String websiteUrl;
    private Double rating;
    private Boolean isActive;
}