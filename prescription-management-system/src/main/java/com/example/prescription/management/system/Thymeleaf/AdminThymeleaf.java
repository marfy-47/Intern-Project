package com.example.prescription.management.system.Thymeleaf;

import com.example.prescription.management.system.JWT.JwtUtils;
import com.example.prescription.management.system.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminThymeleaf {

    private final JwtUtils jwtUtils;
    private final UserService userService;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model, HttpServletRequest request){
        System.out.println("I am Admin Dashboard");
        String jwt = jwtUtils.getJwtFromCookies(request);
        if(jwt==null) return "redirect:/user-logout?message=User not found. Please check your phone and try again.";
        Long userId = jwtUtils.extractUserId(jwt);
        String adminName = userService.findUserById(userId).getName();
        model.addAttribute("adminName",adminName);
        return "AdminDashboard";
    }
}
