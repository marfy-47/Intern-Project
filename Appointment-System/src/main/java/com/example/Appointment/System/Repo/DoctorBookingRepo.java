package com.example.Appointment.System.Repo;

import com.example.Appointment.System.DATA.Entity.DoctorBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorBookingRepo extends JpaRepository<DoctorBooking,Long> {
}


