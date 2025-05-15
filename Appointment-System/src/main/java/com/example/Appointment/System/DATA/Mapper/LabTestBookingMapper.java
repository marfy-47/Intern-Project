package com.example.Appointment.System.DATA.Mapper;
import com.example.Appointment.System.DATA.DTO.LabTestBookingDTO;
import com.example.Appointment.System.DATA.Entity.Hospital;
import com.example.Appointment.System.DATA.Entity.LabTest;
import com.example.Appointment.System.DATA.Entity.LabTestBooking;
import com.example.Appointment.System.DATA.Entity.Patient;
import com.example.Appointment.System.Exception.LabTestBookingNotFoundException;
import com.example.Appointment.System.Exception.PatientNotFoundException;
import com.example.Appointment.System.Repo.HospitalRepo;
import com.example.Appointment.System.Repo.LabTestRepo;
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
    private final LabTestRepo labTestRepo;
    public LabTestBooking toLabTestBooking(LabTestBookingDTO labTestBookingDTO) throws LabTestBookingNotFoundException, PatientNotFoundException {
        System.out.println("-------------------->labId: "+labTestBookingDTO.getLabId()+" labTestId: "+labTestBookingDTO.getLabTestId());
        Optional<Patient> patient=patientRepo.findByPatientContact(SecurityContextHolder.getContext().getAuthentication().getName());
        Optional<Hospital>hospital=hospitalRepo.findById(labTestBookingDTO.getLabId());
        Optional<LabTest> labTest=labTestRepo.findById(labTestBookingDTO.getLabTestId());

        if(hospital.isEmpty()){
            throw new LabTestBookingNotFoundException("LabTestBooking doesn't exit");
        }
        if(patient.isEmpty()){
            throw new PatientNotFoundException("Patient doesn't exit");
        }
        if(labTest.isEmpty()){
            throw new IllegalArgumentException("LabTest dose not exist");
        }

        LabTestBooking labTestBooking= LabTestBooking.builder()
                .labTestName(labTest.get().getLabTestName())
                .oderDate(labTestBookingDTO.getOderDate())
                .status(Status.Confirmed.name())
                .deliveryDate(labTestBookingDTO.getOderDate())
                .note(labTestBookingDTO.getNote())
                .build();
        patient.get().getLabTestBookings().add(labTestBooking);
        hospital.get().getLabTestBookings().add(labTestBooking);
        labTestBooking.setPatient(patient.get());
        labTestBooking.setHospital(hospital.get());
        labTestBooking.setLabTest(labTest.get());
        return labTestBooking;
    }

    public LabTestBookingDTO toLabTestBookingDTO(LabTestBooking labTestBooking) {
        return LabTestBookingDTO.builder()
                .labTestName(labTestBooking.getLabTestName())
                .oderDate(labTestBooking.getOderDate())
                .deliveryDate(labTestBooking.getDeliveryDate())
                .note(labTestBooking.getNote())
                .id(labTestBooking.getId())
                .labId(labTestBooking.getHospital().getId())
                .labTestId(labTestBooking.getLabTest().getId())
                .hospitalName(labTestBooking.getHospital().getHospitalName())
                .status(labTestBooking.getStatus())
                .labTestImageUrl(labTestBooking.getLabTest().getLabTestImageUrl())
                .build();
    }

    public List<LabTestBookingDTO> toLabTestBookingDTOS(List<LabTestBooking> allLabTestBooking) {
        List<LabTestBookingDTO>labTestBookingDTOS=new ArrayList<>();
        for (LabTestBooking labTestBooking:allLabTestBooking){
            labTestBookingDTOS.add(toLabTestBookingDTO(labTestBooking));
        }
        return labTestBookingDTOS;
    }
}
