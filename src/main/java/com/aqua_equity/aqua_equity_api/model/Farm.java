package com.aqua_equity.aqua_equity_api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "farm")
public class Farm {
	private Long id;
	private String farmName;
	private Float hectares;
	private Float quota;
	private Float usedToday;
	private User user;
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
	private Crop crop;
	private Region region;
	
	private List<Alert> alertList;
	private List<IrrigationEvent> irrigationEventList;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "farm_id")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "farm_name", length = 100, nullable = false)
	public String getFarmName() {
		return farmName;
	}
	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}
	
	@Column(name = "hectares", nullable = false)
	public Float getHectares() {
		return hectares;
	}
	public void setHectares(Float hectares) {
		this.hectares = hectares;
	}
	
	@Column(name = "quota", nullable = false)
	public Float getQuota() {
		return quota;
	}
	public void setQuota(Float quota) {
		this.quota = quota;
	}
	
	@Column(name = "used_today", nullable = false)
	public Float getUsedToday() {
		return usedToday;
	}
	
	public void setUsedToday(Float usedToday) {
		this.usedToday = usedToday;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name = "top_left_x", nullable = false)
	public Float getTopLeftX() {
		return topLeftX;
	}
	public void setTopLeftX(Float topLeftX) {
		this.topLeftX = topLeftX;
	}
	
	@Column(name = "top_left_y", nullable = false)
	public Float getTopLeftY() {
		return topLeftY;
	}
	public void setTopLeftY(Float topLeftY) {
		this.topLeftY = topLeftY;
	}
	
	@Column(name = "top_right_x", nullable = false)
	public Float getTopRightX() {
		return topRightX;
	}
	public void setTopRightX(Float topRightX) {
		this.topRightX = topRightX;
	}
	
	@Column(name = "top_right_y", nullable = false)
	public Float getTopRightY() {
		return topRightY;
	}
	public void setTopRightY(Float topRightY) {
		this.topRightY = topRightY;
	}
	
	@Column(name = "bottom_left_x", nullable = false)
	public Float getBottomLeftX() {
		return bottomLeftX;
	}
	public void setBottomLeftX(Float bottomLeftX) {
		this.bottomLeftX = bottomLeftX;
	}
	
	@Column(name = "bottom_left_y", nullable = false)
	public Float getBottomLeftY() {
		return bottomLeftY;
	}
	public void setBottomLeftY(Float bottomLeftY) {
		this.bottomLeftY = bottomLeftY;
	}
	
	@Column(name = "bottom_right_x", nullable = false)
	public Float getBottomRightX() {
		return bottomRightX;
	}
	public void setBottomRightX(Float bottomRightX) {
		this.bottomRightX = bottomRightX;
	}
	
	@Column(name = "bottom_right_y", nullable = false)
	public Float getBottomRightY() {
		return bottomRightY;
	}
	public void setBottomRightY(Float bottomRightY) {
		this.bottomRightY = bottomRightY;
	}
	
	@Column(name = "soil_moisture", nullable = false)
	public Float getSoilMoisture() {
		return soilMoisture;
	}
	public void setSoilMoisture(Float soilMoisture) {
		this.soilMoisture = soilMoisture;
	}
	
	@Column(name = "stress_level", nullable = false)
	public Float getStressLevel() {
		return stressLevel;
	}
	public void setStressLevel(Float stressLevel) {
		this.stressLevel = stressLevel;
	}
	
	@Column(name = "uncertainty_level", nullable = false)
	public Float getUncertaintyLevel() {
		return uncertaintyLevel;
	}
	public void setUncertaintyLevel(Float uncertaintyLevel) {
		this.uncertaintyLevel = uncertaintyLevel;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "crop_id")
	public Crop getCrop() {
		return crop;
	}
	public void setCrop(Crop crop) {
		this.crop = crop;
	}
	
	
	@OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
	public List<Alert> getAlertList() {
		return alertList;
	}

	public void setAlertList(List<Alert> alertList) {
		this.alertList = alertList;
	}
	
	@OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
	public List<IrrigationEvent> getIrrigationEventList() {
		return irrigationEventList;
	}

	public void setIrrigationEventList(List<IrrigationEvent> irrigationEventList) {
		this.irrigationEventList = irrigationEventList;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	
	
}
