package com.example.Prescription_generation.Service;

import com.example.Prescription_generation.Model.DTO.PrescriptionDTO;
import com.example.Prescription_generation.Model.Entity.Prescription;
import com.example.Prescription_generation.Model.Mapper.PrescriptionMapper;
import com.example.Prescription_generation.Repo.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public PrescriptionDTO createPrescription(PrescriptionDTO dto) {
        Prescription entity = PrescriptionMapper.toEntity(dto);
        Prescription saved = prescriptionRepository.save(entity);
        return PrescriptionMapper.toDTO(saved);
    }

    public List<PrescriptionDTO> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionRepository.findAll();
        return prescriptions.stream()
                .map(PrescriptionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PrescriptionDTO getPrescriptionById(Long id) {
        Prescription entity = prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found with id: " + id));
        return PrescriptionMapper.toDTO(entity);
    }

}
