package com.aqua_equity.aqua_equity_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqua_equity.aqua_equity_api.dto.FarmRequestDto;
import com.aqua_equity.aqua_equity_api.model.Crop;
import com.aqua_equity.aqua_equity_api.model.Farm;
import com.aqua_equity.aqua_equity_api.model.Region;
import com.aqua_equity.aqua_equity_api.model.User;
import com.aqua_equity.aqua_equity_api.repo.CropRepo;
import com.aqua_equity.aqua_equity_api.repo.FarmRepo;
import com.aqua_equity.aqua_equity_api.repo.RegionRepo;
import com.aqua_equity.aqua_equity_api.repo.UserRepo;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class FarmService {

	@Autowired
	private FarmRepo farmRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CropRepo cropRepo;
	
	@Autowired
	private RegionRepo regionRepo;
	
	
	public Farm getFarmById(Long id) {
		return farmRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Farm not found with id: " + id));
	}
	
	public List<Farm> getAllFarms() {
		return farmRepo.findAll();
	}
	
	@Transactional
	public List<Farm> getFarmsByRegionId(Long regionId) {
		Region region = regionRepo.findById(regionId).orElseThrow(() -> new RuntimeException("Region not found"));
		return region.getFarmList();
	}
	
	@Transactional
	public List<Farm> getFarmsByUserId(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Region not found"));
		return user.getFarmList();
	}
	
	public Farm createNewFarm(FarmRequestDto request) {
		Farm newFarm = new Farm();
		User user = userRepo.findById(request.getUserId()).orElseThrow(() -> new EntityNotFoundException("No user found with id: " + request.getUserId()));
		Crop crop = cropRepo.findById(request.getCropId()).orElseThrow(() -> new EntityNotFoundException("No crop found with id: " + request.getCropId()));
		Region region = regionRepo.findById(request.getRegionId()).orElseThrow(() -> new EntityNotFoundException("No region found with id: " + request.getRegionId()));
		
		newFarm.setFarmName(request.getFarmName());
		newFarm.setHectares(request.getHectares());
		newFarm.setQuota(request.getQuota());
		newFarm.setUsedToday(request.getUsedToday());
		newFarm.setUser(user);
		newFarm.setTopLeftX(request.getTopLeftX());
		newFarm.setTopLeftY(request.getTopLeftY());
		newFarm.setTopRightX(request.getTopRightX());
		newFarm.setTopRightY(request.getTopRightY());
		newFarm.setBottomLeftX(request.getBottomLeftX());
		newFarm.setBottomLeftY(request.getBottomLeftY());
		newFarm.setBottomRightX(request.getBottomRightX());
		newFarm.setBottomRightY(request.getBottomRightY());
		newFarm.setSoilMoisture(request.getSoilMoisture());
		newFarm.setStressLevel(request.getStressLevel());
		newFarm.setUncertaintyLevel(request.getUncertaintyLevel());
		newFarm.setCrop(crop);
		newFarm.setRegion(region);
		
		return farmRepo.save(newFarm);
	}
	
	public Farm updateFarm(FarmRequestDto request, Long id) {
		Farm farmToUpdate = farmRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("No farm exists with id: " + id));
		
		if(request.getFarmName() != null) farmToUpdate.setFarmName(request.getFarmName());
		if(request.getHectares() != null) farmToUpdate.setHectares(request.getHectares());
		if(request.getQuota() != null) farmToUpdate.setQuota(request.getQuota());
		if(request.getUsedToday() != null) farmToUpdate.setUsedToday(request.getUsedToday());
		if(request.getUserId() != null) {
			User user = userRepo.findById(request.getUserId()).orElseThrow(() -> new EntityNotFoundException("No user found with id: " + request.getUserId()));
			farmToUpdate.setUser(user);
		}
		if(request.getTopLeftX() != null) farmToUpdate.setTopLeftX(request.getTopLeftX());
		if(request.getTopLeftY() != null) farmToUpdate.setTopLeftY(request.getTopLeftY());
		if(request.getTopRightX() != null) farmToUpdate.setTopRightX(request.getTopRightX());
		if(request.getTopRightY() != null) farmToUpdate.setTopRightY(request.getTopRightY());
		if(request.getBottomLeftX() != null) farmToUpdate.setBottomLeftX(request.getBottomLeftX());
		if(request.getBottomLeftY() != null) farmToUpdate.setBottomLeftY(request.getBottomLeftY());
		if(request.getBottomRightX() != null) farmToUpdate.setBottomRightX(request.getBottomRightX());
		if(request.getBottomRightY() != null) farmToUpdate.setBottomRightY(request.getBottomRightY());
		if(request.getSoilMoisture() != null) farmToUpdate.setSoilMoisture(request.getSoilMoisture());
		if(request.getStressLevel() != null) farmToUpdate.setStressLevel(request.getStressLevel());
		if(request.getUncertaintyLevel() != null) farmToUpdate.setUncertaintyLevel(request.getUncertaintyLevel());
		if(request.getCropId() != null) {
			Crop crop = cropRepo.findById(request.getCropId()).orElseThrow(() -> new EntityNotFoundException("No crop found with id: " + request.getCropId()));
			farmToUpdate.setCrop(crop);
		}
		if(request.getRegionId() != null) {
			Region region = regionRepo.findById(request.getRegionId()).orElseThrow(() -> new EntityNotFoundException("No region found with id: " + request.getRegionId()));
			farmToUpdate.setRegion(region);
		}
		
		return farmRepo.save(farmToUpdate);
	}
	
	public void deleteFarm(Long id) {
		Farm farmToDelete = farmRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("No farm exists with id: " + id));
		
		farmRepo.delete(farmToDelete);
	}
	
}
