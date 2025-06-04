package com.example.prescription.management.system.Service;


import com.example.prescription.management.system.Model.DTO.JwtAuthenticationResponseDto;
import com.example.prescription.management.system.Model.DTO.SignInRequestDto;
import com.example.prescription.management.system.Model.Entity.MyUser;

public interface AuthenticationService {
    MyUser sinUp(MyUser user,String defaultRole);
    JwtAuthenticationResponseDto signIn(SignInRequestDto signInRequestDto);
}