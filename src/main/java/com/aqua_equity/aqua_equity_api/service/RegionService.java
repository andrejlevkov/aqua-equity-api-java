package com.aqua_equity.aqua_equity_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqua_equity.aqua_equity_api.model.Region;
import com.aqua_equity.aqua_equity_api.repo.RegionRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RegionService {

	@Autowired
	private RegionRepo regionRepo;
	
	public Region createNewRegion(Region request) {
		return regionRepo.save(request);
	}
	
	public Region updateRegion(Region request, Long id) {
		Region toUpdate = regionRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("No region with id: " + id));
		
		if(request.getRegionName() != null) {
			toUpdate.setRegionName(request.getRegionName());
		}
		else {
			throw new IllegalArgumentException("New name cannot be null");
		}
		
		return regionRepo.save(toUpdate);
	}
	
	public void deleteRegion(Long id) {
		Region toUpdate = regionRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("No region with id: " + id));
		
		regionRepo.delete(toUpdate);
	}
}
