package com.acmeplex.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmeplex.model.User;
import com.acmeplex.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Add a new user
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Find a user by their ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Find a user by username (useful for login)
    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }
}
