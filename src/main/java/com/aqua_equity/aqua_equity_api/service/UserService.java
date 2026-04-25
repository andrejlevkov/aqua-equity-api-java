package com.aqua_equity.aqua_equity_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aqua_equity.aqua_equity_api.model.Farm;
import com.aqua_equity.aqua_equity_api.model.User;
import com.aqua_equity.aqua_equity_api.repo.UserRepo;

@Service
public class UserService {

    private final UserRepo userRepository;

    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    // GET all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // GET user by email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    // GET user by username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }

    // CREATE user
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already in use: " + user.getEmail());
        }
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already in use: " + user.getUsername());
        }
        return userRepository.save(user);
    }

    // UPDATE user (partial)
    @Transactional
    public User updateUser(Long id, User request) {
        User user = getUserById(id);

        if (request.getFristName() != null) user.setFristName(request.getFristName());
        if (request.getLastName() != null) user.setLastName(request.getLastName());
        if (request.getEmail() != null) user.setEmail(request.getEmail());
        if (request.getUsername() != null) user.setUsername(request.getUsername());
        if (request.getPassword() != null) user.setPassword(request.getPassword());
        if (request.getPhoneNumber() != null) user.setPhoneNumber(request.getPhoneNumber());

        return userRepository.save(user);
    }

    // DELETE user
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    // GET farms by user
    @Transactional
    public List<Farm> getFarmsByUser(Long userId) {
        User user = getUserById(userId);
        return user.getFarmList();
    }
}