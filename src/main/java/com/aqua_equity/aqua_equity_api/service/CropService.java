package com.aqua_equity.aqua_equity_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqua_equity.aqua_equity_api.model.Crop;
import com.aqua_equity.aqua_equity_api.repo.CropRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CropService {

	@Autowired
	private CropRepo cropRepo;
	
	public Crop createNewCrop(Crop request) {
		return cropRepo.save(request);
	}
	
	public Crop updateCrop(Crop request, Long id) {
		Crop toUpdate = cropRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("No crop with id: " + id));
		
		if(request.getCropName() != null) {
			toUpdate.setCropName(request.getCropName());
		}
		else {
			throw new IllegalArgumentException("New name cannot be null");
		}
		
		return cropRepo.save(toUpdate);
	}
	
	public void deleteCrop(Long id) {
		Crop toUpdate = cropRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("No crop with id: " + id));
		
		cropRepo.delete(toUpdate);
	}
}
