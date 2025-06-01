package com.example.Prescription_generation.Model.Mapper;

import com.example.Prescription_generation.Model.DTO.PrescriptionDTO;
import com.example.Prescription_generation.Model.Entity.Prescription;


public class PrescriptionMapper {

    public static Prescription toEntity(PrescriptionDTO dto) {
        if (dto == null) return null;
        Prescription entity = new Prescription();
        entity.setPrescriptionDate(dto.getPrescriptionDate());
        entity.setPatientName(dto.getPatientName());
        entity.setPatientAge(dto.getPatientAge());
        entity.setPatientGender(dto.getPatientGender());
        entity.setDiagnosis(dto.getDiagnosis());
        entity.setMedicines(dto.getMedicines());
        entity.setNextVisitDate(dto.getNextVisitDate());
        return entity;
    }

    public static PrescriptionDTO toDTO(Prescription entity) {
        if (entity == null) return null;
        PrescriptionDTO dto = new PrescriptionDTO();
        dto.setPrescriptionDate(entity.getPrescriptionDate());
        dto.setPatientName(entity.getPatientName());
        dto.setPatientAge(entity.getPatientAge());
        dto.setPatientGender(entity.getPatientGender());
        dto.setDiagnosis(entity.getDiagnosis());
        dto.setMedicines(entity.getMedicines());
        dto.setNextVisitDate(entity.getNextVisitDate());
        return dto;
    }
}
