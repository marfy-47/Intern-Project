package com.example.Appointment.System.Service;

import com.example.Appointment.System.DTO.UserDTO;
import com.example.Appointment.System.Entity.User;
import com.example.Appointment.System.Entity.User;
import com.example.Appointment.System.Mapper.UserMapper;
import com.example.Appointment.System.Repo.PatientRepo;
import com.example.Appointment.System.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PatientRepo patientRepo;
    private final UserMapper userMapper;
    public User saveUser(User user) {
        userRepo.save(user);
        return user;
    }

    public User getUserByName(String username) {
        Optional<User> user=userRepo.findByName(username);
        if(user==null){
            return null;
        }
        return user.get();
    }

    public boolean isExitUserById(Long id) {
        return userRepo.existsById(id);
    }

    public User updateUser(Long id, UserDTO userDTO) {
        Optional<User> mUser=userRepo.findById(id);
        if(mUser.isEmpty()){
            return null;
        }
        mUser.get().setEmail(userDTO.getEmail());
        mUser.get().setDateOfBirth(userDTO.getDateOfBirth());
        mUser.get().setGender(userDTO.getGender());
        mUser.get().setContact(userDTO.getContact());
        mUser.get().setPassword(userDTO.getPassword());
        userRepo.save(mUser.get());
        return mUser.get();
    }

    public void deleteUser(Long id) {
        if(!userRepo.existsById(id)){
            return;
        }
        userRepo.deleteById(id);
    }

    public MUser getUserById(Long id) {
        Optional<MUser> mUser=userRepo.findById(id);
        if(mUser.isEmpty()){
            return null;
        }
        return mUser.get();
    }
}
