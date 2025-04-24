package com.example.spring_intro.Controller;

import com.example.spring_intro.Data.DTO.UserRoleDTO;
import com.example.spring_intro.Data.DTO.Entity.UserRole;
import com.example.spring_intro.Service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    @Autowired
    private UserRoleService UserRoleService;


    @GetMapping
    public List<UserRoleDTO> getAllRoles() {
        return UserRoleService.getAllRoles()
                .stream()
                .map(userRole -> new UserRoleDTO(userRole.getId(), userRole.getRole()))
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserRoleDTO> getRoleById(@PathVariable Long id) {
        UserRole userRole = userRoleService.getRoleById(id);
        if (userRole == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new UserRoleDTO(userRole.getId(), userRole.getRole()));
    }


    @PostMapping
    public UserRoleDTO createRole(@RequestBody UserRoleDTO dto) {
        UserRole newRole = userRoleService.createRole(dto);
        return new UserRoleDTO(newRole.getId(), newRole.getRole());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRoleDTO> updateRole(@PathVariable Long id, @RequestBody UserRoleDTO dto) {
        UserRole updated = userRoleService.updateRole(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new UserRoleDTO(updated.getId(), updated.getRole()));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        boolean deleted = userRoleService.deleteRole(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

