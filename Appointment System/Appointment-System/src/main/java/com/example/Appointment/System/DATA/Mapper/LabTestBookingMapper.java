package com.example.Appointment.System.DATA.Mapper;

import com.example.Appointment.System.DATA.DTO.LabTestBookingDTO;
import com.example.Appointment.System.DATA.Entity.Hospital;
import com.example.Appointment.System.DATA.Entity.LabTestBooking;
import com.example.Appointment.System.DATA.Entity.Patient;
import com.example.Appointment.System.Exception.LabTestBookingNotFoundException;
import com.example.Appointment.System.Exception.PatientNotFoundException;
import com.example.Appointment.System.Repo.HospitalRepo;
import com.example.Appointment.System.Repo.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class LabTestBookingMapper {

    private final HospitalRepo hospitalRepo;
    private final PatientRepo patientRepo;

    public LabTestBooking toLabTestBooking(LabTestBookingDTO labTestBookingDTO) throws LabTestBookingNotFoundException, PatientNotFoundException {

        Optional<Patient> patient = patientRepo.findByPatientName(SecurityContextHolder.getContext().getAuthentication().getName());

        Optional<Hospital> hospital = hospitalRepo.findByHospitalName(labTestBookingDTO.getHospitalName());

        Optional<Hospital> hospitalDetails = hospitalRepo.findHospital(
                labTestBookingDTO.getLabTestName(),
                labTestBookingDTO.getCountry(),
                labTestBookingDTO.getCity(),
                labTestBookingDTO.getAddress(),
                labTestBookingDTO.getRoadNo(),
                labTestBookingDTO.getHoldingNo()
        );

        if (hospital.isEmpty() && hospitalDetails.isEmpty()) {
            throw new LabTestBookingNotFoundException("LabTestBooking doesn't exist");
        }
        if (patient.isEmpty()) {
            throw new PatientNotFoundException("Patient doesn't exist");
        }

        LabTestBooking labTestBooking = LabTestBooking.builder()
                .testName(labTestBookingDTO.getLabTestName())
                .orderDate(labTestBookingDTO.getLabTestDate())
                .status("Confirmed")
                .deliveryDate(labTestBookingDTO.getDeliveryDate())
                .note(labTestBookingDTO.getNote())
                .build();

        patient.get().getLabTestBookings().add(labTestBooking);
        hospital.get().getLabTestBookings().add(labTestBooking);

        labTestBooking.setPatient(patient.get());
        labTestBooking.setHospital(hospital.get());

        return labTestBooking;
    }

    public LabTestBookingDTO toLabTestBookingDTO(LabTestBooking labTestBooking) {
        return LabTestBookingDTO.builder()
                .labTestName(labTestBooking.getTestName())
                .labTestDate(labTestBooking.getOrderDate())
                .deliveryDate(labTestBooking.getDeliveryDate())
                .note(labTestBooking.getNote())
                .hospitalName(labTestBooking.getHospital().getHospitalName())
                .status(labTestBooking.getStatus())
                .build();
    }

    public List<LabTestBookingDTO> toLabTestBookingDTOS(List<LabTestBooking> allLabTestBooking) {
        List<LabTestBookingDTO> labTestBookingDTOS = new ArrayList<>();
        for (LabTestBooking labTestBooking : allLabTestBooking) {
            labTestBookingDTOS.add(toLabTestBookingDTO(labTestBooking));
        }
        return labTestBookingDTOS;
    }
}
