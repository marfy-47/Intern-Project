package com.example.spring_intro.Controller;

import com.example.spring_intro.Data.DTO.UserRoleDTO;
import com.example.spring_intro.Data.Entity.UserRole;
import com.example.spring_intro.Service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/{id}")
    public ResponseEntity<UserRoleDTO> getRoleById(@PathVariable Long id) {
        UserRoleDTO userRoleDTO = userRoleService.getRoleById(id);
        return ResponseEntity.ok(userRoleDTO);
    }


    @PostMapping
    public UserRoleDTO createRole(@RequestBody UserRoleDTO dto) {
        UserRoleDTO userRoleDTO = userRoleService.createRole(dto);
        return userRoleDTO;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRoleDTO> updateRole(@PathVariable Long id, @RequestBody UserRoleDTO dto) {
        UserRoleDTO userRoleDTO = userRoleService.updateRole(id, dto);
        return ResponseEntity.ok(userRoleDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        userRoleService.deleteRole(id);
        return ResponseEntity.ok("Delete Successfull....");
    }
}

