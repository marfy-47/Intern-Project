package com.example.Appointment.System.Service;

import com.example.Appointment.System.DATA.DTO.PatientDTO;
import com.example.Appointment.System.DATA.Entity.Patient;
import com.example.Appointment.System.Repo.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepo patientRepo;
    public Patient savePatient(Patient patientProfile) {
        patientRepo.save(patientProfile);
        return patientProfile;
    }
    public boolean isExitPatientById(Long id) {
        return patientRepo.existsById(id);
    }

    public Patient getPatientById(Long id) {
        Optional<Patient> patient=patientRepo.findById(id);
        if(patient.isEmpty()){
            return null;
        }
        return patient.get();
    }

    public void deletePatientByPatientId(Long id) {
        patientRepo.deleteById(id);
    }

    public Patient updatePatientByPatientId(Long id, PatientDTO patientDTO) {
        Optional<Patient> patient=patientRepo.findById(id);
        if(patient.isEmpty()){
            return null;
        }
        patient.get().setDateOfBirth(patientDTO.getDateOfBirth());
        patientRepo.save(patient.get());
        return patient.get();
    }

    public List<Patient> getAllPatient() {
        List<Patient> patientProfiles = patientRepo.findAll();
        if(patientProfiles.isEmpty()){
            return new ArrayList<>();
        }
        return patientRepo.findAll();
    }

    public Patient getPatientByName(String name) {
        Optional<Patient> patient=patientRepo.findByPatientName(name);
        if(patient.isEmpty()){
            return null;
        }
        return patient.get();
    }


}
