package com.example.Appointment.System.Repo;

import com.example.Appointment.System.DATA.Entity.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabTestRepo extends JpaRepository<LabTest,Long> {
    LabTest findByTestName(String name);
    List<LabTest> findByTestNameLike(String name);
}