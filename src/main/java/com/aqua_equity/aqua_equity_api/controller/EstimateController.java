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

import com.aqua_equity.aqua_equity_api.dto.EstimateRequestDto;
import com.aqua_equity.aqua_equity_api.model.Estimate;
import com.aqua_equity.aqua_equity_api.service.EstimateService;

@RestController
@RequestMapping("/api/estimates")
public class EstimateController {

    private final EstimateService estimateService;

    public EstimateController(EstimateService estimateService) {
        this.estimateService = estimateService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Estimate>> getEstimatesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(estimateService.getAllEstimatesByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Estimate> createEstimate(@RequestBody EstimateRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estimateService.createNewEstimate(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Estimate> updateEstimate(@PathVariable Long id, @RequestBody EstimateRequestDto request) {
        return ResponseEntity.ok(estimateService.updateEstimate(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstimate(@PathVariable Long id) {
        estimateService.deleteEstimate(id);
        return ResponseEntity.noContent().build();
    }
}