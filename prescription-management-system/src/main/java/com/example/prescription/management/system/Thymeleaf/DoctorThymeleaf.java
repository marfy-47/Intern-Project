package com.example.prescription.management.system.Thymeleaf;

import com.example.prescription.management.system.Model.DTO.DoctorRegistrationDto;
import com.example.prescription.management.system.Model.Mapper.DoctorMapper;
import com.example.prescription.management.system.Model.Mapper.PrescriptionMapper;
import com.example.prescription.management.system.Validation.RegistrationDataValidation;
import com.example.prescription.management.system.JWT.JwtUtils;
import com.example.prescription.management.system.Model.DTO.PrescriptionDto;
import com.example.prescription.management.system.Model.DTO.PrescriptionFilterDto;
import com.example.prescription.management.system.Model.Entity.MyUser;
import com.example.prescription.management.system.Model.Entity.Prescription;
import com.example.prescription.management.system.Service.PrescriptionService;
import com.example.prescription.management.system.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorThymeleaf {

    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final RegistrationDataValidation validation;
    private final PrescriptionMapper prescriptionMapper;
    private final PrescriptionService prescriptionService;
    private final DoctorMapper doctorMapper;


    @GetMapping("/dashboard")
    public String doctorDashboard(Model model, HttpServletRequest request){

        try {
            String token = jwtUtils.getJwtFromCookies(request);
            if(token!=null) {
                Long userId = jwtUtils.extractUserId(token);
                String doctorName = userService.findUserById(userId).getName();
                model.addAttribute("doctorName",doctorName);
            }
            else return "redirect:/user-logout?message=User not found. Please check your phone and try again.";
        }catch (Exception e) {
            System.out.println("Exception from Doctor Dashboard = "+e.getMessage());
        }
        return "DoctorDashboard";
    }
    @GetMapping("/my-prescriptions") //----------------- See My Prescriptions ----------------------
    public String myPrescriptions(Model model, HttpServletRequest request) {
        return loadPrescriptions(LocalDate.now().minusMonths(1), LocalDate.now(), model, request);
    }

    @PostMapping("/my-prescriptions")
    public String myPrescriptionsPost(@ModelAttribute("filterDto") PrescriptionFilterDto filterDto, Model model, HttpServletRequest request) {
        /*if (filterDto.getStartDate().isAfter(filterDto.getEndDate()) ||
                filterDto.getStartDate().isAfter(LocalDate.now()) ||
                filterDto.getEndDate().isAfter(LocalDate.now()))
            return "redirect:/doctor/my-prescriptions?message=Invalid date range. Please check your date range and try again.";
        */
        System.out.println("data = "+filterDto);
        return loadPrescriptions(filterDto.getStartDate(), filterDto.getEndDate(), model, request);
    }

    private String loadPrescriptions(LocalDate startDate, LocalDate endDate, Model model, HttpServletRequest request) {
        try {
            String token = jwtUtils.getJwtFromCookies(request);
            if (token != null) {
                Long userId = jwtUtils.extractUserId(token);
                MyUser doctor = userService.findUserById(userId);
                String doctorName = doctor.getName();
                model.addAttribute("doctorName", doctorName);

                PrescriptionFilterDto filterDto = new PrescriptionFilterDto(startDate, endDate);
                model.addAttribute("filterDto", filterDto);

                List<Prescription> myPrescriptions = prescriptionService.findOneDoctorAllPrescriptionInDateRange(doctor, startDate, endDate);
                model.addAttribute("myPrescriptions", myPrescriptions);

                return "PrescriptionsTable";
            } else {
                return "redirect:/user-logout?message=User not found. Please check your phone and try again.";
            }
        } catch (Exception e) {
            System.out.println("Exception from Doctor Thymeleaf = " + e.getMessage());
            return "redirect:/user-logout?message=User not found. Please check your phone and try again.";
        }
    }
    @GetMapping("/edit-prescription/{prescriptionId}") //-------------- Edit Prescription ----------------------
    public String editPrescription(@PathVariable("prescriptionId") Long prescriptionId, Model model){
        try {
            Prescription prescription = prescriptionService.findPrescriptionById(prescriptionId);
            PrescriptionDto prescriptionDto = prescriptionMapper.mapToDto(prescription);
            prescriptionDto.setPrescriptionId(prescriptionId);
            model.addAttribute("PrescriptionDto",prescriptionDto);
            //return "EditPrescription";
            return "EditPrescription";
        }catch (Exception e){
            System.out.println("Exception form Doctor Thymeleaf = "+e.getMessage());
            return "redirect:/user-logout?message=User not found. Please check your phone and try again.";
        }
    }
    @PostMapping("/update-prescription")
    public String updatePrescription(@ModelAttribute("PrescriptionDto") PrescriptionDto dto, Model model,HttpServletRequest request){
        System.out.println("id = "+dto.getPrescriptionId()+" Date = "+dto.getPrescriptionDate()+"Name = "+dto.getPatientName());
        try {
            Prescription prescription = prescriptionService.findPrescriptionById(dto.getPrescriptionId());
            prescription = prescriptionMapper.updatePrescriptionInfo(prescription,dto);
            prescription = prescriptionService.updatePrescription(prescription);
            return "redirect:/doctor/my-prescriptions";
        }catch (Exception e){
            System.out.println("Exception form Doctor Thymeleaf = "+e.getMessage());
            return "redirect:/doctor/dashboard?message="+e.getMessage();
        }
    }
    @GetMapping("/prescription/delete/{prescriptionId}")
    public String deletePrescription(@PathVariable("prescriptionId") Long prescriptionId, Model model,HttpServletRequest request){
        try {
            String jwt = jwtUtils.getJwtFromCookies(request);
            if(jwt==null) return "redirect:/user-logout?message=User not found. Please check your phone and try again.";
            Long userId = jwtUtils.extractUserId(jwt);
            MyUser doctor = userService.findUserById(userId);
            if(doctor != null){
                System.out.println("delete prescription id = "+prescriptionId);
                prescriptionService.deletePrescriptionById(prescriptionId);
                return "redirect:/doctor/my-prescriptions?message=Prescription deleted successfully";
            }
            else return "redirect:/user-logout?message=Server error, Prescription not delete";
        }catch (Exception e){
            System.out.println("Exception form Doctor Thymeleaf = "+e.getMessage());
            return "redirect:/user-logout?message=Server error, Prescription not delete";
        }
    }
    @GetMapping("/write-prescription") //-------------------------------- write prescription------------------
    public String writePrescription(Model model){
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        model.addAttribute("PrescriptionDto",prescriptionDto);
        return "PrescriptionForm";
    }
    @PostMapping("/write-prescription")
    public String writePrescription(@ModelAttribute("PrescriptionDto") PrescriptionDto dto, Model model,HttpServletRequest request){
        try {

            String jwt = jwtUtils.getJwtFromCookies(request);
            if(jwt==null) return "redirect:/user-logout?message=User not found. Please check your phone and try again.";
            Long userId = jwtUtils.extractUserId(jwt);
            MyUser doctor = userService.findUserById(userId);

            String validationResult = validation.prescriptionValidation(dto);
            if(!validationResult.equals("valid"))
                return "redirect:/doctor/write-prescription?message="+validationResult;
            Prescription prescription = prescriptionMapper.mapToEntity(dto);
            prescription = prescriptionService.savePrescription(prescription,doctor);
            if(prescription != null) {
                return "redirect:/doctor/dashboard?message=Patient registration successful";
            }
            else return "redirect:/doctor/write-prescription?message=Server error, Patient not save";
        }catch (Exception e){
            System.out.println("Exception form Doctor Thymeleaf = "+e.getMessage());
            return "redirect:/doctor/write-prescription?message="+e.getMessage();
        }
    }

    @GetMapping("/report")
    public String getReport(Model model){
        return "Report";
    }

    @GetMapping("/profile")
    public String getProfile(Model model){
        String contact= SecurityContextHolder.getContext().getAuthentication().getName();
        MyUser doctor = userService.findUserByPhone(contact);
        DoctorRegistrationDto doctorRegistrationDto=doctorMapper.mapToDTO(doctor);
        model.addAttribute("doctor",doctorRegistrationDto);
        return "Profile";
    }




}
