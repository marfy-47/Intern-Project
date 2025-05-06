package com.example.Appointment.System.Controller;

import com.example.Appointment.System.Entity.MUser;
import com.example.Appointment.System.JWT.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")

private final AuthenticationManager authManager;
private final JwtUtil jwtUtil;
private final UserDetailsService uds;

public AuthController(AuthenticationManager am, JwtUtil ju, UserDetailsService uds) {
    this.authManager = am;
    this.jwtUtil = ju;
    this.uds = uds;
}

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody AuthRequest req) {
    try {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
        );
    } catch (BadCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    MUser user = uds.loadUserByUsername(req.getUsername());
    String token = jwtUtil.generateToken(user);
    return ResponseEntity.ok(new AuthResponse(token));
}

