package com.acmeplex.controller;

import com.acmeplex.model.User;
import com.acmeplex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Add a new user
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Get a user by username (useful for login)
    @GetMapping("/username/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
}
