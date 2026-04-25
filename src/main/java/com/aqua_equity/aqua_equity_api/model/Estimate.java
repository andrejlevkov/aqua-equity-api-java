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
@Table(name = "estimates")
public class Estimate {

	private Long id;
	private Farm farm;
	private LocalDateTime estimateDate;
	private Float xPred;
	private Float pPred;
	private Float xUpd;
	private Float pUpd;
	private Float rainMm;
	private Float et0Mm;
	private Float irrigationMm;
	private Float ndviMean;
	private Float moistureMeanMm;
	private Boolean Updated;
	private Float stressLevel;
	private Boolean measurementAvailable;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estimate_id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "farm_id")
	public Farm getFarm() {
		return farm;
	}
	public void setFarm(Farm farm) {
		this.farm = farm;
	}
	
	@Column(name = "estimate_date", nullable = false)
	public LocalDateTime getEstimateDate() {
		return estimateDate;
	}
	public void setEstimateDate(LocalDateTime estimateDate) {
		this.estimateDate = estimateDate;
	}
	
	@Column(name = "x_pred")
	public Float getxPred() {
		return xPred;
	}
	public void setxPred(Float xPred) {
		this.xPred = xPred;
	}
	
	@Column(name = "p_pred")
	public Float getpPred() {
		return pPred;
	}
	public void setpPred(Float pPred) {
		this.pPred = pPred;
	}
	
	@Column(name = "x_upd")
	public Float getxUpd() {
		return xUpd;
	}
	public void setxUpd(Float xUpd) {
		this.xUpd = xUpd;
	}
	
	@Column(name = "p_upd")
	public Float getpUpd() {
		return pUpd;
	}
	public void setpUpd(Float pUpd) {
		this.pUpd = pUpd;
	}
	
	@Column(name = "rain_mm")
	public Float getRainMm() {
		return rainMm;
	}
	public void setRainMm(Float rainMm) {
		this.rainMm = rainMm;
	}
	
	@Column(name = "et0_mm")
	public Float getEt0Mm() {
		return et0Mm;
	}
	public void setEt0Mm(Float et0Mm) {
		this.et0Mm = et0Mm;
	}
	
	@Column(name = "irrigation_mm")
	public Float getIrrigationMm() {
		return irrigationMm;
	}
	public void setIrrigationMm(Float irrigationMm) {
		this.irrigationMm = irrigationMm;
	}
	
	@Column(name = "ndvi_mean")
	public Float getNdviMean() {
		return ndviMean;
	}
	public void setNdviMean(Float ndviMean) {
		this.ndviMean = ndviMean;
	}
	
	@Column(name = "moisture_mean_mm")
	public Float getMoistureMeanMm() {
		return moistureMeanMm;
	}
	public void setMoistureMeanMm(Float moistureMeanMm) {
		this.moistureMeanMm = moistureMeanMm;
	}
	
	@Column(name = "updated")
	public Boolean getUpdated() {
		return Updated;
	}
	public void setUpdated(Boolean updated) {
		Updated = updated;
	}
	
	@Column(name = "stress_level")
	public Float getStressLevel() {
		return stressLevel;
	}
	public void setStressLevel(Float stressLevel) {
		this.stressLevel = stressLevel;
	}
	
	@Column(name = "measurement_available")
	public Boolean getMeasurementAvailable() {
		return measurementAvailable;
	}
	public void setMeasurementAvailable(Boolean measurementAvailable) {
		this.measurementAvailable = measurementAvailable;
	}
	
	
    
}
