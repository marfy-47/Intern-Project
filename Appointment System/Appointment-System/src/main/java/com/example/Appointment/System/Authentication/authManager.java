package com.example.Appointment.System.Authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@Bean
public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder encoder,
                                         UserDetailsService uds) throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(uds)
            .passwordEncoder(encoder)
            .and()
            .build();
}

@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
