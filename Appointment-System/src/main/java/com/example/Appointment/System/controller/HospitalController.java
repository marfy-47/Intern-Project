package com.example.Appointment.System.Controller;

import com.example.Appointment.System.DATA.DTO.HospitalDTO;
import com.example.Appointment.System.DATA.Mapper.HospitalMapper;
import com.example.Appointment.System.Exception.HospitalNotFoundException;
import com.example.Appointment.System.Service.HospitalService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hospital")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class HospitalController {
    private final HospitalService hospitalService;
    private final HospitalMapper hospitalMapper;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("End Point Test");
    }
    @PostMapping("/register")
    public ResponseEntity<HospitalDTO> registerHospital(HospitalDTO hospitalDTO){

        return ResponseEntity.ok(
                hospitalMapper.toHospitalDTO(hospitalService.saveHospital(
                        hospitalMapper.toHospital(hospitalDTO)
                )));
    }
    @GetMapping("/fetch/{id}")
    public ResponseEntity<HospitalDTO> fetchHospitalById(@PathVariable Long id) throws HospitalNotFoundException {
        if(!hospitalService.isExitHospitalById(id)){
            throw new HospitalNotFoundException("Hospital doesn't exit");
        }
        return ResponseEntity.ok(
                hospitalMapper.toHospitalDTO(hospitalService.getHospitalById(id))
        );
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteHospitalById(@PathVariable Long id) throws HospitalNotFoundException {
        if(!hospitalService.isExitHospitalById(id)){
            throw new HospitalNotFoundException("Hospital doesn't exit!!");
        }
       hospitalService.removeHospital(id);
        return ResponseEntity.ok("Hospital deleted successfully!!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<HospitalDTO> updateHospitalById(@PathVariable Long id,@RequestBody HospitalDTO hospitalDTO) throws HospitalNotFoundException {
        if(!hospitalService.isExitHospitalById(id)){
            throw new HospitalNotFoundException("Hospital doesn't exit!!");
        }
        return ResponseEntity.ok(
                hospitalMapper.toHospitalDTO(hospitalService.updateHospital(id,hospitalDTO))
        );
    }
    @GetMapping("fetch/all")
    public ResponseEntity<List<HospitalDTO>> fetchAllHospital() throws HospitalNotFoundException {
        if(hospitalService.getAllHospital().isEmpty()){
            throw new HospitalNotFoundException("Hospital doesn't exit");
        }
        return ResponseEntity.ok(
                hospitalMapper.toHospitalDTOS(hospitalService.getAllHospital())
        );
    }
}