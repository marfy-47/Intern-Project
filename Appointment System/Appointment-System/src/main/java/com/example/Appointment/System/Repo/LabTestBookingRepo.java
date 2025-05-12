package com.example.Appointment.System.Repo;

import com.example.Appointment.System.DATA.Entity.LabTestBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTestBookingRepo extends JpaRepository<LabTestBooking,Long> {

}