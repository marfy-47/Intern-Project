package com.example.spring_intro.Service;

import com.example.spring_intro.DTO.UserRoleDTO;
import com.example.spring_intro.Entity.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> getAllRoles();
    UserRole getRoleById(Long id);
    UserRole createRole(UserRoleDTO dto);
    UserRole updateRole(Long id, UserRoleDTO dto);
    boolean deleteRole(Long id);
}
