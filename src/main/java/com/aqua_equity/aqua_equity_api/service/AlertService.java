package com.aqua_equity.aqua_equity_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqua_equity.aqua_equity_api.dto.AlertRequestDto;
import com.aqua_equity.aqua_equity_api.model.Alert;
import com.aqua_equity.aqua_equity_api.model.Farm;
import com.aqua_equity.aqua_equity_api.repo.AlertRepo;
import com.aqua_equity.aqua_equity_api.repo.FarmRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AlertService {

	@Autowired
	private AlertRepo alertRepo;
	
	@Autowired
	private FarmRepo farmRepo;
	
	public Alert createNewAlert(AlertRequestDto request) {
		Alert newAlert = new Alert();
		Farm farm = farmRepo.findById(request.getFarmId()).orElseThrow(() -> new EntityNotFoundException("No farm with id: " + request.getFarmId()));
		
		newAlert.setFarm(farm);
		newAlert.setMessage(request.getMessage());
		newAlert.setSeverity(request.getSeverity());
		newAlert.setTimeStamp(request.getTimeStamp());
		newAlert.setWaterAmount(request.getWaterAmount());
		
		return alertRepo.save(newAlert);
	}
	
	public List<Alert> getAllAlertsByUserId(Long userId) {
		return alertRepo.findAlertsByUserId(userId);
	}
	
	public Alert updateAlert(AlertRequestDto request, Long alertId) {
		Alert alertToUpdate = alertRepo.findById(alertId).orElseThrow(() -> new EntityNotFoundException("No alert with id: " + request.getId()));
		
		
		if(request.getFarmId() != null) {
			Farm farm = farmRepo.findById(request.getFarmId()).orElseThrow(() -> new EntityNotFoundException("No farm with id: " + request.getFarmId()));
			alertToUpdate.setFarm(farm);
		}
		if(request.getMessage() != null) alertToUpdate.setMessage(request.getMessage());
		if(request.getSeverity() != null) alertToUpdate.setSeverity(request.getSeverity());
		if(request.getTimeStamp() != null) alertToUpdate.setTimeStamp(request.getTimeStamp());
		if(request.getWaterAmount() != null) alertToUpdate.setWaterAmount(request.getWaterAmount());
		
		return alertRepo.save(alertToUpdate);
	}
	
	public void deleteAlert(Long alertId) {
		Alert alertToDelete = alertRepo.findById(alertId).orElseThrow(() -> new EntityNotFoundException("No alert with id: " + alertId));
		
		alertRepo.delete(alertToDelete);
	}
}
