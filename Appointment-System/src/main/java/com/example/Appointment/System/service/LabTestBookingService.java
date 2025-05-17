package com.example.Appointment.System.Service;

import com.example.Appointment.System.DATA.DTO.LabTestBookingDTO;
import com.example.Appointment.System.DATA.Entity.LabTestBooking;
import com.example.Appointment.System.Repo.LabTestBookingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LabTestBookingService {

    private final LabTestBookingRepo labTestBookingRepo;

    public LabTestBooking saveLabTestBooking(LabTestBooking labTestBooking) {
        return labTestBookingRepo.save(labTestBooking);
    }

    public boolean existsLabTestBookingById(Long id) {
        return labTestBookingRepo.existsById(id);
    }

    public LabTestBooking getLabTestBookingById(Long id) {
        return labTestBookingRepo.findById(id).orElse(null);
    }

    public void removeLabTestBookingById(Long id) {
        if (labTestBookingRepo.existsById(id)) {
            labTestBookingRepo.deleteById(id);
        }
    }

    public LabTestBooking modifyLabTestBookingById(Long id, LabTestBookingDTO dto) {
        Optional<LabTestBooking> optionalBooking = labTestBookingRepo.findById(id);
        if (optionalBooking.isEmpty()) {
            return null;
        }

        LabTestBooking booking = optionalBooking.get();
        booking.setTestName(dto.getLabTestName());
        booking.setDateOfBooking(LocalDate.from(dto.getOderDate()));
        booking.setDeliveryDate(LocalDate.from(dto.getDeliveryDate()));
        booking.setNote(dto.getNote());

        return labTestBookingRepo.save(booking);
    }

    public List<LabTestBooking> getAllLabTestBookings() {
        return labTestBookingRepo.findAll();
    }

}
