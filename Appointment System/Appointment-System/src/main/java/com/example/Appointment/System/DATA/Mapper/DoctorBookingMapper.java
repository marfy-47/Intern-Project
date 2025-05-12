package com.example.Appointment.System.DATA.Mapper;
import com.example.Appointment.System.DATA.DTO.DoctorBookingDTO;
import com.example.Appointment.System.DATA.Entity.Doctor;
import com.example.Appointment.System.DATA.Entity.DoctorBooking;
import com.example.Appointment.System.DATA.Entity.Patient;
import com.example.Appointment.System.Repo.DoctorRepo;
import com.example.Appointment.System.Repo.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DoctorBookingMapper {
    private final PatientRepo patientRepo;
    private final DoctorRepo doctorRepo;
    public DoctorBookingDTO toDoctorBookingDTO(DoctorBooking doctorBooking) {

        return DoctorBookingDTO.builder()
                .bookingDate(Instant.from(doctorBooking.getBookingDate()))
                .appointmentDate(doctorBooking.getAppointmentDate())
                .note(doctorBooking.getNote())
                .status(doctorBooking.getStatus())
                .designation(doctorBooking.getDoctor().getDesignation())
                .degrees(doctorBooking.getDoctor().getDegrees() )
                .hospitalOrClinicName(doctorBooking.getDoctor().getHospitalOrClinicName())
                .licenseNumber(doctorBooking.getDoctor().getLicenseNumber())
                .doctorName(doctorBooking.getDoctor().getDoctorName())
                .build();
    }
    public DoctorBooking toDoctorBooking(DoctorBookingDTO doctorBookingDTO)  {
        String patientName= SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Patient> patient=patientRepo.findByPatientName(patientName);
        Optional<Doctor> doctor=doctorRepo.findByLicenseNumber(doctorBookingDTO.getLicenseNumber());
        if(patient.isEmpty()){
            throw new IllegalArgumentException("Patient doesn't found");
        }
        if(doctor.isEmpty()){
            throw new IllegalArgumentException("Doctor doesn't exit");
        }

        DoctorBooking doctorBooking= DoctorBooking.builder()
                .bookingDate(doctorBookingDTO.getBookingDate())
                .appointmentDate(doctorBookingDTO.getAppointmentDate())
                .note(doctorBookingDTO.getNote())
                .status(Status.Confirmed.name())
                .build();
        patient.get().setDoctorBookings(Set.of(doctorBooking));
        doctor.get().setDoctorBookings(Set.of(doctorBooking));
        patient.get().setDoctor(Set.of(doctor.get()) );
        doctor.get().setPatient(Set.of(patient.get()) );
        doctorBooking.setPatient(patient.get());
        doctorBooking.setDoctor(doctor.get());
        return doctorBooking;

    }


    public List<DoctorBookingDTO> toDoctorBookingDTOS(List<DoctorBooking> doctorBookings) {
        List<DoctorBookingDTO>doctorBookingDTOS=new java.util.ArrayList<>();
        for (DoctorBooking doctorBooking:doctorBookings){
            doctorBookingDTOS.add(toDoctorBookingDTO(doctorBooking));
        }
        return doctorBookingDTOS;
    }
}