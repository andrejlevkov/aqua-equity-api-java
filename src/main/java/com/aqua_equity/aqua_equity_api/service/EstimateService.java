package com.aqua_equity.aqua_equity_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqua_equity.aqua_equity_api.dto.EstimateRequestDto;
import com.aqua_equity.aqua_equity_api.model.Estimate;
import com.aqua_equity.aqua_equity_api.model.Farm;
import com.aqua_equity.aqua_equity_api.repo.EstimateRepo;
import com.aqua_equity.aqua_equity_api.repo.FarmRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EstimateService {

	@Autowired
	private EstimateRepo estimateRepo;
	
	@Autowired
	private FarmRepo farmRepo;
	
	public Estimate createNewEstimate(EstimateRequestDto request) {
		Estimate newEstimate = new Estimate();
		Farm farm = farmRepo.findById(request.getFarmId()).orElseThrow(() -> new EntityNotFoundException("No farm with id: " + request.getFarmId()));
		
		newEstimate.setFarm(farm);
		newEstimate.setEstimateDate(request.getEstimateDate());
		newEstimate.setxPred(request.getxPred());
		newEstimate.setpPred(request.getpPred());
		newEstimate.setxUpd(request.getxUpd());
		newEstimate.setpUpd(request.getpUpd());
		newEstimate.setRainMm(request.getRainMm());
		newEstimate.setEt0Mm(request.getEt0Mm());
		newEstimate.setIrrigationMm(request.getIrrigationMm());
		newEstimate.setNdviMean(request.getNdviMean());
		newEstimate.setMoistureMeanMm(request.getMoistureMeanMm());
		newEstimate.setUpdated(request.getUpdated());
		newEstimate.setStressLevel(request.getStressLevel());
		newEstimate.setMeasurementAvailable(request.getMeasurementAvailable());
		
		
		
		return estimateRepo.save(newEstimate);
	}
	
	public Estimate updateEstimate(EstimateRequestDto request, Long estimateId) {
		Estimate newEstimate = estimateRepo.findById(estimateId).orElseThrow(() -> new EntityNotFoundException("No estimate with id: " + estimateId));
		
		if(request.getFarmId() != null) {
			Farm farm = farmRepo.findById(request.getFarmId()).orElseThrow(() -> new EntityNotFoundException("No farm with id: " + request.getFarmId()));
			newEstimate.setFarm(farm);
		}
		if(request.getEstimateDate() != null) newEstimate.setEstimateDate(request.getEstimateDate());
		if(request.getxPred() != null) newEstimate.setxPred(request.getxPred());
		if(request.getpPred() != null) newEstimate.setpPred(request.getpPred());
		if(request.getxUpd() != null) newEstimate.setxUpd(request.getxUpd());
		if(request.getpUpd() != null) newEstimate.setpUpd(request.getpUpd());
		if(request.getRainMm() != null) newEstimate.setRainMm(request.getRainMm());
		if(request.getEt0Mm() != null) newEstimate.setEt0Mm(request.getEt0Mm());
		if(request.getIrrigationMm() != null) newEstimate.setIrrigationMm(request.getIrrigationMm());
		if(request.getNdviMean() != null) newEstimate.setNdviMean(request.getNdviMean());
		if(request.getMoistureMeanMm() != null) newEstimate.setMoistureMeanMm(request.getMoistureMeanMm());
		if(request.getUpdated() != null) newEstimate.setUpdated(request.getUpdated());
		if(request.getStressLevel() != null) newEstimate.setStressLevel(request.getStressLevel());
		if(request.getMeasurementAvailable() != null) newEstimate.setMeasurementAvailable(request.getMeasurementAvailable());
		
		return estimateRepo.save(newEstimate);
	}
	
	public List<Estimate> getAllEstimatesByUserId(Long userId) {
		return estimateRepo.findAlertsByUserId(userId);
	}
	
	public void deleteEstimate(Long id) {
		Estimate newEstimate = estimateRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("No estimate with id: " + id));
		
		estimateRepo.delete(newEstimate);
	}
}
