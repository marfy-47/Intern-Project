package com.example.Appointment.System.Controller;


import com.example.Appointment.System.DATA.DTO.LabTestBookingDTO;
import com.example.Appointment.System.DATA.Mapper.LabTestBookingMapper;
import com.example.Appointment.System.Exception.LabTestBookingNotFoundException;
import com.example.Appointment.System.Exception.PatientNotFoundException;
import com.example.Appointment.System.Service.LabTestBookingService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lab/test/booking")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class LabTestBookingController {
    private final LabTestBookingService labTestBookingService;
    private final LabTestBookingMapper labTestBookingMapper;
    @GetMapping("/test")
    public ResponseEntity<String> test()  {
        return ResponseEntity.ok("End Point Test");
    }
    @PostMapping("/register")
    public ResponseEntity<LabTestBookingDTO> registerLabTestBooking(@RequestBody LabTestBookingDTO labTestBookingDTO) throws PatientNotFoundException, LabTestBookingNotFoundException {
        return ResponseEntity.ok(labTestBookingMapper.toLabTestBookingDTO(
                labTestBookingService.saveLabTestBooking(labTestBookingMapper.toLabTestBooking(labTestBookingDTO))));
    }
    @GetMapping("/fetch/{id}")
    public ResponseEntity<LabTestBookingDTO> fetchLabTestBookingById(@PathVariable("id") Long id) throws LabTestBookingNotFoundException {
        if(!labTestBookingService.isExitLabTestBookingById(id)){
            throw new LabTestBookingNotFoundException("LabTestBooking doesn't exit");
        }
        return ResponseEntity.ok(
                labTestBookingMapper.toLabTestBookingDTO(labTestBookingService.getLabTestBookingById(id))
        );
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLabTestBookingById(@PathVariable Long id) throws LabTestBookingNotFoundException {
        if(!labTestBookingService.isExitLabTestBookingById(id)){
            throw new LabTestBookingNotFoundException("LabTestBooking doesn't exit");
        }
        labTestBookingService.removeLabTestBookingById(id);
        return ResponseEntity.ok("LabTestBooking deleted successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<LabTestBookingDTO> updateLabTestBookingById(@PathVariable("id") Long id,@RequestBody LabTestBookingDTO labTestBookingDTO) throws LabTestBookingNotFoundException, PatientNotFoundException {
        if(!labTestBookingService.isExitLabTestBookingById(id)){
            throw new LabTestBookingNotFoundException("LabTestBooking doesn't exit");
        }
        return ResponseEntity.ok(labTestBookingMapper.toLabTestBookingDTO(
                labTestBookingService.modifyLabTestBookingById(id,labTestBookingDTO)));
    }
    @GetMapping("/fetch/all")
    public ResponseEntity<List<LabTestBookingDTO>> fetchAllLabTestBookings() throws LabTestBookingNotFoundException {
        if(labTestBookingService.getAllLabTestBooking().isEmpty()){
            throw new LabTestBookingNotFoundException("LabTestBooking doesn't exit");
        }
        return ResponseEntity.ok(
                labTestBookingMapper.toLabTestBookingDTOS(labTestBookingService.getAllLabTestBooking())
        );
    }
}