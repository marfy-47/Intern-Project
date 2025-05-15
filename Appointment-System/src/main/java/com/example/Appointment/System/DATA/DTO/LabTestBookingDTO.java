package com.example.Appointment.System.DATA.DTO;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class LabTestBookingDTO {
    @Column(nullable = false)
    private String labTestName;
    private String LabTestId;
    private String LabId;
    private String note;
    private String status;
    private Instant  oderDate;
    private Instant deliveryDate;
    private String diagnosticCenterName;
    private String country;
    private String city;
    private String zipCode;
    private String address;
    private String roadNo;
    private String holdingNo;


}