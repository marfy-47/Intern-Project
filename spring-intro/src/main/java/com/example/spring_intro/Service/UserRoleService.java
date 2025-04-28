package com.example.spring_intro.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {



    public UserRoleDTO getRoleById(Long id)
    {
        Optional<UserRole> userRole = userRoleRepository.findById(id);
        if(!userRole.isPresent())
        {
            return null;
        }
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        userRoleDTO.setId(userRole.get().getId());
        userRoleDTO.setRole(userRole.get().getRole());
        return userRoleDTO;

    }
    public UserRoleDTO createRole(UserRoleDTO dto)
    {
        UserRole userRole = new UserRole();
        userRole.setRole(dto.getRole());
        userRole.setUsers(dto.getUsers());
        return dto;
    }
    public UserRoleDTO updateRole(Long id, UserRoleDTO dto)
    {
        UserRole userRole = userRoleRepository.findById(id).get();
        userRole.setRole(dto.getRole());
        userRole.setUsers(dto.getUsers());
        return dto;
    }
    public void deleteRole(Long id)
    {
        userRoleRepository.deleteById(id);
    }
}
