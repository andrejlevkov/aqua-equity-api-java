package com.aqua_equity.aqua_equity_api.dto;

import java.time.LocalDateTime;


public class AlertRequestDto {
	private Long id;
	private Long farmId;
	private String message;
	private String severity;
	private LocalDateTime timeStamp;
	private Float waterAmount;
	
	
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Float getWaterAmount() {
		return waterAmount;
	}
	public void setWaterAmount(Float waterAmount) {
		this.waterAmount = waterAmount;
	}
	
	
}
