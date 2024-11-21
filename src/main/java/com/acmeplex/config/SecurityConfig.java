package com.acmeplex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for testing, enable in production if needed
            .authorizeRequests()
              //  .requestMatchers("/api/auth/login", "/api/auth/signup").permitAll() // Allow access to login and signup
            .requestMatchers("/**").permitAll() // Allow all requests without authentication    
            .anyRequest().authenticated(); // Require authentication for other endpoints
        return http.build();
    }
}
