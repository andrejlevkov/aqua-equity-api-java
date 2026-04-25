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

import com.aqua_equity.aqua_equity_api.dto.FarmRequestDto;
import com.aqua_equity.aqua_equity_api.model.Farm;
import com.aqua_equity.aqua_equity_api.service.FarmService;

@RestController
@RequestMapping("/api/farms")
public class FarmController {

    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farm> getFarmById(@PathVariable Long id) {
        return ResponseEntity.ok(farmService.getFarmById(id));
    }

    @GetMapping
    public ResponseEntity<List<Farm>> getAllFarms() {
        return ResponseEntity.ok(farmService.getAllFarms());
    }

    @GetMapping("/region/{regionId}")
    public ResponseEntity<List<Farm>> getFarmsByRegion(@PathVariable Long regionId) {
        return ResponseEntity.ok(farmService.getFarmsByRegionId(regionId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Farm>> getFarmsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(farmService.getFarmsByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Farm> createFarm(@RequestBody FarmRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(farmService.createNewFarm(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Farm> updateFarm(@PathVariable Long id, @RequestBody FarmRequestDto request) {
        return ResponseEntity.ok(farmService.updateFarm(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarm(@PathVariable Long id) {
        farmService.deleteFarm(id);
        return ResponseEntity.noContent().build();
    }
}