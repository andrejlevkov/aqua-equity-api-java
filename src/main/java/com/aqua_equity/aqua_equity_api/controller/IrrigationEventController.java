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

import com.aqua_equity.aqua_equity_api.dto.IrrigationEventRequestDto;
import com.aqua_equity.aqua_equity_api.model.IrrigationEvent;
import com.aqua_equity.aqua_equity_api.service.IrrigationEventService;

@RestController
@RequestMapping("/api/irrigation-events")
public class IrrigationEventController {

    private final IrrigationEventService irrigationEventService;

    public IrrigationEventController(IrrigationEventService irrigationEventService) {
        this.irrigationEventService = irrigationEventService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<IrrigationEvent>> getIrrigationEventsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(irrigationEventService.getAllIrrigationEventsByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<IrrigationEvent> createIrrigationEvent(@RequestBody IrrigationEventRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(irrigationEventService.createNewIrrigationEvent(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<IrrigationEvent> updateIrrigationEvent(@PathVariable Long id, @RequestBody IrrigationEventRequestDto request) {
        return ResponseEntity.ok(irrigationEventService.updateIrrigationEvent(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIrrigationEvent(@PathVariable Long id) {
        irrigationEventService.deleteIrrigationEvent(id);
        return ResponseEntity.noContent().build();
    }
}