package com.example.prescription.management.system.implementation;

import com.example.prescription.management.system.Model.Entity.MyUser;
import com.example.prescription.management.system.Model.Entity.Role;
import com.example.prescription.management.system.Repository.RoleRepository;
import com.example.prescription.management.system.Repository.UserRepository;
import com.example.prescription.management.system.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImplementation implements RoleService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public Role addRole(String roleName) {
        roleName = roleName.toUpperCase();

        if (roleRepository.findByName(roleName).isPresent()) return roleRepository.findByName(roleName).get();
        try {
            Role role = new Role();
            role.setName(roleName);
            return roleRepository.save(role);
        }catch (Exception e){
            System.out.println("Exception from RoleServiceImplementation.addRole = "+e.getMessage());
            return null;
        }
    }

    @Override
    public Role findRoleByName(String name) {
        System.out.println("Role name = "+name);
        return roleRepository.findByName(name).orElse(null);
    }

    @Override
    public MyUser setUserRole(MyUser user, String roleName) {
        Role role = findRoleByName(roleName);
        if(role == null) {
            role = addRole(roleName);
        }
        try {
            user.getRoles().add(role);
            return userRepository.save(user);
        }catch (Exception e) {
            System.out.println("Exception form RoleServiceImplementation.setUserRole = "+e.getMessage());
            return null;
        }
    }
}
