package com.example.Appointment.System.Repo;

import com.example.Appointment.System.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {
    Optional<Patient> findByPatientName(String patientName);
    }
