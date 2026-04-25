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
import org.springframework.web.bind.annotation.RestController;

import com.aqua_equity.aqua_equity_api.dto.AlertRequestDto;
import com.aqua_equity.aqua_equity_api.model.Alert;
import com.aqua_equity.aqua_equity_api.service.AlertService;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Alert>> getAlertsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(alertService.getAllAlertsByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Alert> createAlert(@RequestBody AlertRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alertService.createNewAlert(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Alert> updateAlert(@PathVariable Long id, @RequestBody AlertRequestDto request) {
        return ResponseEntity.ok(alertService.updateAlert(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Long id) {
        alertService.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }
}