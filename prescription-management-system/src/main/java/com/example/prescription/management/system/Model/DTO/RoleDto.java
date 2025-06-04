package com.example.prescription.management.system.Model.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private String name;
    @Schema(hidden = true)
    private Set<Long> users;
}
