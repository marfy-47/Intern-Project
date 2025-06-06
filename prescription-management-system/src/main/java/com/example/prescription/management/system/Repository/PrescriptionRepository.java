package com.example.prescription.management.system.Repository;

import com.example.prescription.management.system.Model.Entity.MyUser;
import com.example.prescription.management.system.Model.Entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    List<Prescription> findAllByPrescriptionDateBetween(LocalDate startDate, LocalDate endDate);
    List<Prescription> findByDoctorAndPrescriptionDateBetween(MyUser doctor, LocalDate startDate, LocalDate endDate);
}
