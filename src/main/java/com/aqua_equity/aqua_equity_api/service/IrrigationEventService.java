package com.aqua_equity.aqua_equity_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqua_equity.aqua_equity_api.dto.IrrigationEventRequestDto;
import com.aqua_equity.aqua_equity_api.model.Farm;
import com.aqua_equity.aqua_equity_api.model.IrrigationEvent;
import com.aqua_equity.aqua_equity_api.repo.FarmRepo;
import com.aqua_equity.aqua_equity_api.repo.IrrigationEventRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class IrrigationEventService {

	@Autowired
	private IrrigationEventRepo irrigationEventRepo;
	
	@Autowired
	private FarmRepo farmRepo;
	
	public IrrigationEvent createNewIrrigationEvent(IrrigationEventRequestDto request) {
		IrrigationEvent newIrrigationEvent = new IrrigationEvent();
		Farm farm = farmRepo.findById(request.getFarmId()).orElseThrow(() -> new EntityNotFoundException("No farm with id: " + request.getFarmId()));
		
		newIrrigationEvent.setFarm(farm);
		newIrrigationEvent.setWaterAmount(request.getWaterAmount());
		newIrrigationEvent.setTimeStamp(request.getTimeStamp());
		newIrrigationEvent.setPriority(request.getPriority());
		
		return irrigationEventRepo.save(newIrrigationEvent);
	}
	
	public IrrigationEvent updateIrrigationEvent(IrrigationEventRequestDto request, Long id) {
		IrrigationEvent newIrrigationEvent = irrigationEventRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("No irrigation event with id: " + id));
		
		if(request.getFarmId() != null) {
			Farm farm = farmRepo.findById(request.getFarmId()).orElseThrow(() -> new EntityNotFoundException("No farm with id: " + request.getFarmId()));
			newIrrigationEvent.setFarm(farm);
		}
		
		if(request.getWaterAmount() != null) newIrrigationEvent.setWaterAmount(request.getWaterAmount());
		if(request.getTimeStamp() != null) newIrrigationEvent.setTimeStamp(request.getTimeStamp());
		if(request.getPriority() != null) newIrrigationEvent.setPriority(request.getPriority());
		return irrigationEventRepo.save(newIrrigationEvent);
	}
	
	public List<IrrigationEvent> getAllIrrigationEventsByUserId(Long userId) {
		return irrigationEventRepo.findIrrigationEventsByUserId(userId);
	}
	
	public void deleteIrrigationEvent(Long id) {
		IrrigationEvent newIrrigationEvent = irrigationEventRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("No irrigation event with id: " + id));
		
		irrigationEventRepo.delete(newIrrigationEvent);
	}
}
