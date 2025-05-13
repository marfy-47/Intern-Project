package com.example.Appointment.System.service;
import com.example.Appointment.System.model.dto.LabTestBookingDTO;
import com.example.Appointment.System.model.entity.LabTestBooking;
import com.example.Appointment.System.repository.LabTestBookingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LabTestBookingService {
    private final LabTestBookingRepo labTestBookingRepo;

    public LabTestBooking saveLabTestBooking(LabTestBooking labTestBooking) {
        labTestBookingRepo.save(labTestBooking);
        return labTestBooking;
    }

    public boolean isExitLabTestBookingById(Long id) {
        return labTestBookingRepo.existsById(id);
    }

    public LabTestBooking getLabTestBookingById(Long id) {
        Optional<LabTestBooking> labTestBooking=labTestBookingRepo.findById(id);
        if(labTestBooking.isEmpty()){
            return null;
        }
        return labTestBooking.get();
    }

    public void removeLabTestBookingById(Long id) {
        if(!isExitLabTestBookingById(id)){
            return;
        }
        labTestBookingRepo.deleteById(id);
    }

    public LabTestBooking modifyLabTestBookingById(Long id, LabTestBookingDTO labTestBookingDTO) {
        Optional<LabTestBooking> labTestBooking=labTestBookingRepo.findById(id);
        if(labTestBooking.isEmpty()){
            return null;
        }
        labTestBooking.get().setLabTestName(labTestBookingDTO.getLabTestName());
        labTestBooking.get().setOderDate(labTestBookingDTO.getOderDate());
        labTestBooking.get().setDeliveryDate(labTestBookingDTO.getDeliveryDate());
        labTestBooking.get().setNote(labTestBookingDTO.getNote());
        labTestBookingRepo.save(labTestBooking.get());
        return labTestBooking.get();
    }

    public List<LabTestBooking> getAllLabTestBooking() {
        List<LabTestBooking> labTestBookings = labTestBookingRepo.findAll();
        if(labTestBookings.isEmpty()){
            return new ArrayList<>();
        }
        return labTestBookingRepo.findAll();
    }

    public List<LabTestBooking> getAllLabTestBookHistoryByUser() {
        String patientContact = SecurityContextHolder.getContext().getAuthentication().getName();
        List<LabTestBooking> labTestBookings = labTestBookingRepo.findAllByUserContact(patientContact);
        if(labTestBookings.isEmpty()){
            return new ArrayList<>();
        }
        return labTestBookings;
    }
}
