package com.example.Appointment.System.Service;
import com.example.Appointment.System.DATA.DTO.DoctorDTO;
import com.example.Appointment.System.DATA.Entity.Doctor;
import com.example.Appointment.System.Repo.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepo doctorRepo;

    public Doctor saveDoctor(Doctor doctorProfile) {
        doctorRepo.save(doctorProfile);
        return doctorProfile;
    }

    public boolean isExitDoctorById(Long id) {
        return doctorRepo.existsById(id);
    }

    public Doctor updateDoctorById(Long id, DoctorDTO doctorDTO) {
        Optional<Doctor> doctor=doctorRepo.findById(id);
        if(doctor.isEmpty()){
            return null;
        }
        doctor.get().setLanguagesSpoken(doctorDTO.getLanguagesSpoken());
        doctor.get().setYearsOfExperience(doctorDTO.getYearsOfExperience());
        doctor.get().setDesignation(doctorDTO.getDesignation());
        doctor.get().setLicenseNumber(doctorDTO.getLicenseNumber());
        doctor.get().setHospitalOrClinicName(doctorDTO.getHospitalOrClinicName());
        doctor.get().setAvailabilityStatus(doctorDTO.getAvailabilityStatus());
        doctor.get().setDegrees(doctorDTO.getDegrees());
        doctorRepo.save(doctor.get());
        return doctor.get();
    }

    public Doctor getDoctorById(Long id) {
        Optional<Doctor> doctor=doctorRepo.findById(id);
        if(doctor.isEmpty()){
            return null;
        }
        return doctor.get();
    }

    public void deleteDoctorByDoctorId(Long id) {
        Optional<Doctor> doctor=doctorRepo.findById(id);
        if(doctor.isEmpty()){
            return;
        }
        doctorRepo.deleteById(id);
    }

    public List<Doctor> getAllDoctor() {
        List<Doctor> doctorProfiles = doctorRepo.findAll();
        if(doctorProfiles.isEmpty()){
            return new ArrayList<>();
        }
        return doctorRepo.findAll();
    }
}
