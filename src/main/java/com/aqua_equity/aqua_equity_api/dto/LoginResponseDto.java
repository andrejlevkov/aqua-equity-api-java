package com.aqua_equity.aqua_equity_api.dto;

public class LoginResponseDto {
    private Long id;
    private String email;
    private String username;
    private String message;

    public LoginResponseDto(Long id, String email, String username, String message) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.message = message;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getMessage() { return message; }
}