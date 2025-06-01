package com.example.Prescription_generation.Repo;

import com.example.Prescription_generation.Model.Entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
