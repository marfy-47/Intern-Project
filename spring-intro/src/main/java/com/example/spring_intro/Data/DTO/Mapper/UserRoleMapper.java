package com.example.spring_intro.Data.DTO.Mapper;

import com.example.spring_intro.Data.DTO.Entity.UserRole;
import org.springframework.stereotype.Component;

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
