//package com.example.Appointment.System.JWT;
//
//import com.example.Appointment.System.Service.MUserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final JwtUtil jwtUtil;
//    private final MUserService uds;
//
//    public SecurityConfig(JwtUtil jwtUtil, UserDetailsService uds) {
//        this.jwtUtil = jwtUtil;
//        this.uds = uds;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(jwtUtil, uds);
//
//        http
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeHttpRequests()
//                .antMatchers("/api/auth/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//}
//
