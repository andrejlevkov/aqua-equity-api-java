package com.aqua_equity.aqua_equity_api.dto;

import java.time.LocalDateTime;


public class IrrigationEventRequestDto {

	private Long id;
	private Long farmId;
	private Float waterAmount;
	private LocalDateTime timeStamp;
	private Float priority;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFarmId() {
		return farmId;
	}
	public void setFarmId(Long farmId) {
		this.farmId = farmId;
	}
	public Float getWaterAmount() {
		return waterAmount;
	}
	public void setWaterAmount(Float waterAmount) {
		this.waterAmount = waterAmount;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Float getPriority() {
		return priority;
	}
	public void setPriority(Float priority) {
		this.priority = priority;
	}
	
	
}
