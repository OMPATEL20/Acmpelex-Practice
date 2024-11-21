package com.acmeplex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acmeplex.model.User;
import com.acmeplex.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    // Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user != null && BCrypt.checkpw(loginRequest.getPassword(), user.getPassword())) {
            return ResponseEntity.ok("Login successful! User type: " + user.getUserType());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // Signup
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User newUser) {
        if (userRepository.findByUsername(newUser.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already taken");
        }

        // Encrypt the password before saving
        newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
        userRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
}
