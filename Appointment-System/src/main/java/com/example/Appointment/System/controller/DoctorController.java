package com.example.Appointment.System.Controller;

import com.example.Appointment.System.DATA.DTO.DoctorDTO;
import com.example.Appointment.System.Exception.DoctorNotFoundException;
import com.example.Appointment.System.DATA.Mapper.DoctorMapper;
import com.example.Appointment.System.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;
    @PostMapping("/register")
    public ResponseEntity<DoctorDTO> registerDoctor(@RequestBody DoctorDTO doctorDTO){

        return ResponseEntity.ok(doctorMapper.toDoctorDTO(
                doctorService.saveDoctor(doctorMapper.toDoctor(doctorDTO))
        ));}
    @GetMapping("/fetch/{id}")
    public ResponseEntity<DoctorDTO> fetchDoctorById(@PathVariable("id") Long id) throws DoctorNotFoundException {
        if(!doctorService.isExitDoctorById(id)){
            throw new DoctorNotFoundException("Doctor doesn't exits");
        }
        return ResponseEntity.ok(doctorMapper.toDoctorDTO(
                doctorService.getDoctorById(id)));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<DoctorDTO> updateDoctorById(@PathVariable("id") Long id,@RequestBody DoctorDTO doctorDTO) throws DoctorNotFoundException{
        if(!doctorService.isExitDoctorById(id)){
            throw new DoctorNotFoundException("Doctor doesn't exit");
        }
        return ResponseEntity.ok(doctorMapper.toDoctorDTO(
                doctorService.updateDoctorById(id,doctorDTO)));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctorById(@PathVariable("id") Long id) throws DoctorNotFoundException{
        if(!doctorService.isExitDoctorById(id)){
            throw new DoctorNotFoundException("Doctor doesn't exits");
        }
        doctorService.deleteDoctorByDoctorId(id);
        return ResponseEntity.ok("Doctor deleted successfully!!");
    }
    @GetMapping("/fetch/all")
    public ResponseEntity<List<DoctorDTO>> fetchAllDoctors() throws DoctorNotFoundException {
        if(doctorService.getAllDoctor().isEmpty()){
            throw new DoctorNotFoundException("Doctor doesn't exits");
        }
        return ResponseEntity.ok(doctorMapper.toDoctorDTOs(doctorService.getAllDoctor()));
    }
}