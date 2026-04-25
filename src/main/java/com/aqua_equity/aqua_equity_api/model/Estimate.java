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

	Long id;
	Farm farm;
	LocalDateTime estimateDate;
	Float xPred;
	Float pPred;
	Float xUpd;
	Float pUpd;
	Float rainMm;
	Float et0Mm;
	Float irrigationMm;
	Float ndviMean;
	Float moistureMeanMm;
	Boolean Updated;
	Float stressLevel;
	
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
	
	
    
}
