package com.example.spring_intro.Mapper;

import com.example.spring_intro.DTO.UserRoleDTO;
import com.example.spring_intro.Entity.UserRole;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleMapper {


    public UserRole toUserRole(RoleDTO roleDTO) {
        UserRole userRole=new UserRole();
        userRole.setRole(roleDTO.getRole());
        return userRole;
    }

    public <UserRoleDTO> UserRoleDTO toUserDTO(UserRole userRole) {
        UserRoleDTO roleDTO=new UserRole();
        userroleDTO.setRole(userRole.getRole());
        return roleDTO;
    }
}
