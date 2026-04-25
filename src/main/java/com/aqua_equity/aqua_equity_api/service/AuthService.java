package com.aqua_equity.aqua_equity_api.service;

import org.springframework.stereotype.Service;

import com.aqua_equity.aqua_equity_api.dto.LoginRequestDto;
import com.aqua_equity.aqua_equity_api.dto.LoginResponseDto;
import com.aqua_equity.aqua_equity_api.model.User;
import com.aqua_equity.aqua_equity_api.repo.UserRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AuthService {

    private final UserRepo userRepo;

    public AuthService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public LoginResponseDto login(LoginRequestDto request) {
        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("No user found with email: " + request.getEmail()));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        return new LoginResponseDto(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                "Login successful"
        );
    }
}