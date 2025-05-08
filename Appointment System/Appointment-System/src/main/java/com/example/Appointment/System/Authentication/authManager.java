import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

