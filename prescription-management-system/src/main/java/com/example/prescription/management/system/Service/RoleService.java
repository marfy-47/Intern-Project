package com.example.prescription.management.system.Service;

import com.example.prescription.management.system.Model.Entity.MyUser;
import com.example.prescription.management.system.Model.Entity.Role;

public interface RoleService {
    Role addRole(String roleName);
    Role findRoleByName(String name);
    MyUser setUserRole(MyUser user, String roleName);
}
