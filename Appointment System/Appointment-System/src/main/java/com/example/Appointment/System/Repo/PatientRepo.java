package com.example.Appointment.System.Repo;

import com.example.Appointment.System.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {
    Patient findByPatientName(String patientName);
}
