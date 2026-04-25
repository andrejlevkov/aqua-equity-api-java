package com.aqua_equity.aqua_equity_api.dto;

public class FarmRequestDto {

	private Long id;
	private String farmName;
	private Float hectares;
	private Float quota;
	private Float usedToday;
	private Long userId;
	private Float topLeftX;
	private Float topLeftY;
	private Float topRightX;
	private Float topRightY;
	private Float bottomLeftX;
	private Float bottomLeftY;
	private Float bottomRightX;
	private Float bottomRightY;
	private Float soilMoisture;
	private Float stressLevel;
	private Float uncertaintyLevel;
	private Long cropId;
	private Long regionId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFarmName() {
		return farmName;
	}
	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}
	public Float getHectares() {
		return hectares;
	}
	public void setHectares(Float hectares) {
		this.hectares = hectares;
	}
	public Float getQuota() {
		return quota;
	}
	public void setQuota(Float quota) {
		this.quota = quota;
	}
	public Float getUsedToday() {
		return usedToday;
	}
	public void setUsedToday(Float usedToday) {
		this.usedToday = usedToday;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Float getTopLeftX() {
		return topLeftX;
	}
	public void setTopLeftX(Float topLeftX) {
		this.topLeftX = topLeftX;
	}
	public Float getTopLeftY() {
		return topLeftY;
	}
	public void setTopLeftY(Float topLeftY) {
		this.topLeftY = topLeftY;
	}
	public Float getTopRightX() {
		return topRightX;
	}
	public void setTopRightX(Float topRightX) {
		this.topRightX = topRightX;
	}
	public Float getTopRightY() {
		return topRightY;
	}
	public void setTopRightY(Float topRightY) {
		this.topRightY = topRightY;
	}
	public Float getBottomLeftX() {
		return bottomLeftX;
	}
	public void setBottomLeftX(Float bottomLeftX) {
		this.bottomLeftX = bottomLeftX;
	}
	public Float getBottomLeftY() {
		return bottomLeftY;
	}
	public void setBottomLeftY(Float bottomLeftY) {
		this.bottomLeftY = bottomLeftY;
	}
	public Float getBottomRightX() {
		return bottomRightX;
	}
	public void setBottomRightX(Float bottomRightX) {
		this.bottomRightX = bottomRightX;
	}
	public Float getBottomRightY() {
		return bottomRightY;
	}
	public void setBottomRightY(Float bottomRightY) {
		this.bottomRightY = bottomRightY;
	}
	public Float getSoilMoisture() {
		return soilMoisture;
	}
	public void setSoilMoisture(Float soilMoisture) {
		this.soilMoisture = soilMoisture;
	}
	public Float getStressLevel() {
		return stressLevel;
	}
	public void setStressLevel(Float stressLevel) {
		this.stressLevel = stressLevel;
	}
	public Float getUncertaintyLevel() {
		return uncertaintyLevel;
	}
	public void setUncertaintyLevel(Float uncertaintyLevel) {
		this.uncertaintyLevel = uncertaintyLevel;
	}
	public Long getCropId() {
		return cropId;
	}
	public void setCropId(Long cropId) {
		this.cropId = cropId;
	}
	public Long getRegionId() {
		return regionId;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	
	
	
}
