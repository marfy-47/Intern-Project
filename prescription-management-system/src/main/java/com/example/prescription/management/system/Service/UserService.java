package com.example.prescription.management.system.Service;

import com.example.prescription.management.system.Model.Entity.MyUser;


public interface UserService {
    public MyUser saveUser(MyUser user);
    public MyUser findUserByPhone(String phone);
    public MyUser findUserById(Long id);
    public void deleteUserById(Long id);
}
