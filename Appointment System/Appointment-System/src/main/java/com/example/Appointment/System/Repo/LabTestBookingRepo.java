package com.example.Appointment.System.Repo;

import com.example.Appointment.System.Entity.TestBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTestBookingRepo extends JpaRepository<TestBooking,Long> {

}