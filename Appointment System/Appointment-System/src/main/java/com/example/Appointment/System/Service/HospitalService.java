package com.example.Appointment.System.Service;

import com.example.Appointment.System.DATA.DTO.HospitalDTO;
import com.example.Appointment.System.DATA.Entity.Hospital;
import com.example.Appointment.System.Repo.HospitalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepo hospitalRepo;


    public Hospital saveHospital(Hospital hospital) {
        hospitalRepo.save(hospital);
        return hospital;
    }

    public boolean isExitHospitalById(Long id) {
        return hospitalRepo.existsById(id);
    }

    public Hospital getHospitalById(Long id) {
        Optional<Hospital> hospital=hospitalRepo.findById(id);
        if(hospital.isEmpty()){
            return null;
        }
        return hospital.get();
    }

    public void removeHospital(Long id) {
        if(!isExitHospitalById(id)){
            return;
        }
        hospitalRepo.deleteById(id);
    }

    public Hospital updateHospital(Long id, HospitalDTO hospitalDTO) {
        Optional<Hospital> hospital=hospitalRepo.findById(id);
        if(hospital.isEmpty()){
            return null;
        }
        hospital.get().setAddress(hospitalDTO.getAddress());
        hospital.get().setCity(hospitalDTO.getCity());
        hospital.get().setCountry(hospitalDTO.getCountry());
        hospital.get().setHospitalName(hospitalDTO.getHospitalName());
        hospital.get().setContactNumber(hospitalDTO.getContactNumber());
        hospital.get().setAddress(hospitalDTO.getAddress());
        hospital.get().setHoldingNo(hospitalDTO.getHoldingNo());
        hospital.get().setRoadNo(hospitalDTO.getRoadNo());
        hospital.get().setZipCode(hospitalDTO.getZipCode());
        hospital.get().setOperatingHours(hospitalDTO.getOperatingHours());
        hospitalRepo.save(hospital.get());
        return hospital.get();
    }

    public List<Hospital> getAllHospital() {
        List<Hospital> hospital = hospitalRepo.findAll();
        if(hospital.isEmpty()){
            return new java.util.ArrayList<>();
        }
        return hospitalRepo.findAll();
    }

    public void removeHospital(Long id) {
    }
}