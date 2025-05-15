package com.example.Appointment.System.Service;

import com.example.Appointment.System.DATA.DTO.LabTestDTO;
import com.example.Appointment.System.DATA.Entity.LabTest;
import com.example.Appointment.System.Repo.LabTestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LabTestService {
    private final LabTestRepo labTestRepo;

    public LabTest saveLabTest(LabTest labTest) {
        labTestRepo.save(labTest);
        return labTest;
    }

    public boolean isExitLabTestById(Long id) {
        return labTestRepo.existsById(id);
    }

    public LabTest getLabTestById(Long id) {
        Optional<LabTest> labTest=labTestRepo.findById(id);
        if(labTest.isEmpty()){
            return null;
        }
        return labTest.get();
    }

    public void removeLabTestById(Long id) {
        if(!isExitLabTestById(id)){
            return;
        }
        labTestRepo.deleteById(id);
    }

    public LabTest updateLabTest(Long id, LabTestDTO labTestDTO) {
        Optional<LabTest> labTest=labTestRepo.findById(id);
        if(labTest.isEmpty()){
            return null;
        }
        labTest.get().setLabTestName(labTestDTO.getLabTestName());
        labTest.get().setLabTestImageUrl(labTestDTO.getLabTestImageUrl());
        labTestRepo.save(labTest.get());
        return labTest.get();
    }
}