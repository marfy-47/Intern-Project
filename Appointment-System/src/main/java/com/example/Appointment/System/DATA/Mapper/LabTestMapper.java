package com.example.Appointment.System.DATA.Mapper;

import com.example.Appointment.System.DATA.DTO.LabTestDTO;
import com.example.Appointment.System.DATA.Entity.LabTest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LabTestMapper {
    public LabTest toLabTest(LabTestDTO labTestDTO) {
        return LabTest.builder()
                .labTestName(labTestDTO.getLabTestName())
                .labTestImageUrl(labTestDTO.getLabTestImageUrl())
                .build();
    }

    public LabTestDTO toLabTestDTO(LabTest labTest) {
        return LabTestDTO.builder()
                .labTestName(labTest.getLabTestName())
                .labTestImageUrl(labTest.getLabTestImageUrl())
                .build();
    }
}