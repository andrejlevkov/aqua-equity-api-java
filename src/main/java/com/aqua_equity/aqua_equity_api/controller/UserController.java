package com.aqua_equity.aqua_equity_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aqua_equity.aqua_equity_api.model.Farm;
import com.aqua_equity.aqua_equity_api.model.User;
import com.aqua_equity.aqua_equity_api.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<User> getUserByEmailOrUsername(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String username) {
        if (email != null) {
            return ResponseEntity.ok(userService.getUserByEmail(email));
        }
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @GetMapping("/{id}/farms")
    public ResponseEntity<List<Farm>> getFarmsByUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getFarmsByUser(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}