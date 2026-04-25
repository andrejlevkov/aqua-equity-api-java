package com.aqua_equity.aqua_equity_api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "irrigation_event")
public class IrrigationEvent {
	
	private Long id;
	private Farm farm;
	private Float waterAmount;
	private LocalDateTime timeStamp;
	private Float priority;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "irrigation_event_id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "farm_id")
	public Farm getFarm() {
		return farm;
	}
	public void setFarm(Farm farm) {
		this.farm = farm;
	}
	
	@Column(name = "water_amount", nullable = false)
	public Float getWaterAmount() {
		return waterAmount;
	}
	public void setWaterAmount(Float waterAmount) {
		this.waterAmount = waterAmount;
	}
	
	@Column(name = "time_stamp", nullable = false)
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	@Column(name = "priority", nullable = false)
	public Float getPriority() {
		return priority;
	}
	public void setPriority(Float priority) {
		this.priority = priority;
	}
	
}
