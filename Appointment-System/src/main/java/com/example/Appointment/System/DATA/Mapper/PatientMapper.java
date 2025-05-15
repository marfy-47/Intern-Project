package com.example.Appointment.System.DATA.Mapper;

import com.example.Appointment.System.DATA.DTO.PatientDTO;
import com.example.Appointment.System.DATA.Entity.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientMapper {

    public Patient toPatient(PatientDTO patientDTO) {
        return Patient.builder()
                .dateOfBirth(patientDTO.getDateOfBirth())
                .build();
    }

    public PatientDTO toPatientDTO(Patient patientProfile) {
        return PatientDTO.builder()
                .dateOfBirth(patientProfile.getDateOfBirth())
                .build();
    }

    public List<PatientDTO> toPatientDTOS(List<Patient> allPatientProfile) {
        List<PatientDTO>patientDTOS=new ArrayList<>();
        for (Patient patientProfile : allPatientProfile){
            patientDTOS.add(toPatientDTO(patientProfile));
        }
        return patientDTOS;
    }
}