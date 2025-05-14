package com.example.Appointment.System.service;

import com.example.Appointment.System.model.dto.DoctorDTO;
import com.example.Appointment.System.model.entity.DoctorProfile;
import com.example.Appointment.System.repository.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepo doctorRepo;

    public DoctorProfile saveDoctor(DoctorProfile doctorProfile) {
        doctorRepo.save(doctorProfile);
        return doctorProfile;
    }

    public boolean isExitDoctorById(Long id) {
        return doctorRepo.existsById(id);
    }

    public DoctorProfile updateDoctorById(Long id, DoctorDTO doctorDTO) {
        Optional<DoctorProfile> doctor=doctorRepo.findById(id);
        if(doctor.isEmpty()){
            return null;
        }
        doctor.get().setLanguagesSpoken(doctorDTO.getLanguagesSpoken());
        doctor.get().setYearsOfExperience(doctorDTO.getYearsOfExperience());
        doctor.get().setDesignation(doctorDTO.getDesignation());
        doctor.get().setDegrees(doctorDTO.getDegrees());
        doctor.get().setLicenseNumber(doctorDTO.getLicenseNumber());
        doctor.get().setDoctorName(doctorDTO.getDoctorName());
        doctor.get().setHospitalOrClinicName(doctorDTO.getHospitalOrClinicName());
        doctor.get().setAvailabilityStatus(doctorDTO.getAvailabilityStatus());
        doctor.get().setProfilePictureUrl(doctorDTO.getProfilePictureUrl());
        doctorRepo.save(doctor.get());
        return doctor.get();
    }

    public DoctorProfile getDoctorById(Long id) {
        Optional<DoctorProfile> doctor=doctorRepo.findById(id);
        if(doctor.isEmpty()){
            return null;
        }
        return doctor.get();
    }

    public void deleteDoctorByDoctorId(Long id) {
        Optional<DoctorProfile> doctor=doctorRepo.findById(id);
        if(doctor.isEmpty()){
            return;
        }
        doctorRepo.deleteById(id);
    }

    public List<DoctorProfile> getAllDoctor() {
        List<DoctorProfile> doctorProfiles = doctorRepo.findAll();
        if(doctorProfiles.isEmpty()){
            return new ArrayList<>();
        }
        return doctorRepo.findAll();
    }
}
