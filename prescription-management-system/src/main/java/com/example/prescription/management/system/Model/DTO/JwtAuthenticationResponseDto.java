package com.example.prescription.management.system.Model.DTO;

import lombok.Data;

@Data
public class JwtAuthenticationResponseDto {
    private String token;
    private String refreshToken;
}
