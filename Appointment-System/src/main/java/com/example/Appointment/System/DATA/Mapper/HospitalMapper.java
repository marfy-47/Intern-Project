package com.example.Appointment.System.DATA.Mapper;

import com.example.Appointment.System.DATA.Entity.Hospital;
import com.example.Appointment.System.DATA.DTO.HospitalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class HospitalMapper {

    public Hospital toHospital(HospitalDTO hospitalDTO) {
        return Hospital.builder()
                .hospitalName(hospitalDTO.getHospitalName())
                .email(hospitalDTO.getEmail())
                .city(hospitalDTO.getCity())
                .country(hospitalDTO.getCountry())
                .address(hospitalDTO.getAddress())
                .roadNo(hospitalDTO.getRoadNo())
                .holdingNo(hospitalDTO.getHoldingNo())
                .operatingHours(hospitalDTO.getOperatingHours())
                .contactNumber(hospitalDTO.getContactNumber())
                .zipCode(hospitalDTO.getZipCode())
                .build();
    }

    public HospitalDTO toHospitalDTO(Hospital hospital) {
        return HospitalDTO.builder()
                .hospitalName(hospital.getHospitalName())
                .contactNumber(hospital.getContactNumber())
                .operatingHours(hospital.getOperatingHours())
                .zipCode(hospital.getZipCode())
                .roadNo(hospital.getRoadNo())
                .holdingNo(hospital.getHoldingNo())
                .address(hospital.getAddress())
                .country(hospital.getCountry())
                .city(hospital.getCity())
                .email(hospital.getEmail())
                .build();
    }

    // Update this method to be non-static
    public List<HospitalDTO> toHospitalDTOS(List<Hospital> allHospital) {
        List<HospitalDTO> hospitalDTOS = new ArrayList<>();
        for (Hospital hospital : allHospital) {
            hospitalDTOS.add(toHospitalDTO(hospital));  // Call the instance method here
        }
        return hospitalDTOS;
    }
}
