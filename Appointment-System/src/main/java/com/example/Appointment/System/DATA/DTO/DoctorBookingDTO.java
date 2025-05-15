package com.example.Appointment.System.DATA.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class DoctorBookingDTO {
    @JsonProperty(value = "doctor_name",required = true,defaultValue = "doctor_name")
    private String doctorName;
    private String licenseNumber;
    private String hospitalOrClinicName;
    private List<String> degrees;
    private String designation;
    private String note;
    private String status;
    private Instant  bookingDate;
    private Instant appointmentDate;

}