package com.example.Appointment.System.Controller;

import com.example.Appointment.System.DTO.UserDTO;
import com.example.Appointment.System.Entity.User;
import com.example.Appointment.System.Exception.UserNotFoundException;
import com.example.Appointment.System.JWT.JwtUtil;
import com.example.Appointment.System.Mapper.PatientMapper;
import com.example.Appointment.System.Mapper.UserMapper;
import com.example.Appointment.System.Service.PatientService;
import com.example.Appointment.System.Service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserAuthController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final PatientMapper patientMapper;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PatientService patientService;
    @PostMapping("/signup")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(
                userMapper.toUserDTO(userService.saveUser(userMapper.toUser(userDTO)))
        );
    }
    @PostMapping("/signin")
    public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.getPassword()));
        String token=jwtUtil.generateToken(loginDTO.getUsername());
        User user=userService.getUserByName(loginDTO.getUsername());
        user.setIsActive(true);
        userService.saveUser(user);
        return ResponseEntity.ok(token);
    }
    @PostMapping("/signout")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<String> logoutUser(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.ok("Invalid token");
        }
        String token = authHeader.substring(7);
        String username=jwtUtil.extractUsername(token);
        User user=userService.getUserByName(username);
        user.setIsActive(false);
        userService.saveUser(user);
        return ResponseEntity.ok("Logout successfully");
    }
    @PutMapping("/update/{id}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable Long id,@RequestBody UserDTO userDTO) throws UserNotFoundException {
        if(!userService.isExitUserById(id)){
            throw new UserNotFoundException("User doesn't exit");
        }
        return ResponseEntity.ok(
                userMapper.toUserDTO(userService.updateUser(id,userDTO))
        );
    }
    @DeleteMapping("/delete/{id}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) throws UserNotFoundException {
        if(!userService.isExitUserById(id)){
            throw new UserNotFoundException("User doesn't exit");
        }
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping("/fetch/{id}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<UserDTO> fetchUserById(@PathVariable Long id) throws UserNotFoundException {
        if(!userService.isExitUserById(id)){
            throw new UserNotFoundException("User doesn't exit");
        }
        return ResponseEntity.ok(userMapper.toUserDTO(userService.getUserById(id)));
    }

}
