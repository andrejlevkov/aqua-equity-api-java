package com.aqua_equity.aqua_equity_api.dto;

import java.time.LocalDateTime;

public class EstimateRequestDto {

	Long id;
	Long farmId;
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
	Boolean measurementAvailable;
	
	
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
	public LocalDateTime getEstimateDate() {
		return estimateDate;
	}
	public void setEstimateDate(LocalDateTime estimateDate) {
		this.estimateDate = estimateDate;
	}
	public Float getxPred() {
		return xPred;
	}
	public void setxPred(Float xPred) {
		this.xPred = xPred;
	}
	public Float getpPred() {
		return pPred;
	}
	public void setpPred(Float pPred) {
		this.pPred = pPred;
	}
	public Float getxUpd() {
		return xUpd;
	}
	public void setxUpd(Float xUpd) {
		this.xUpd = xUpd;
	}
	public Float getpUpd() {
		return pUpd;
	}
	public void setpUpd(Float pUpd) {
		this.pUpd = pUpd;
	}
	public Float getRainMm() {
		return rainMm;
	}
	public void setRainMm(Float rainMm) {
		this.rainMm = rainMm;
	}
	public Float getEt0Mm() {
		return et0Mm;
	}
	public void setEt0Mm(Float et0Mm) {
		this.et0Mm = et0Mm;
	}
	public Float getIrrigationMm() {
		return irrigationMm;
	}
	public void setIrrigationMm(Float irrigationMm) {
		this.irrigationMm = irrigationMm;
	}
	public Float getNdviMean() {
		return ndviMean;
	}
	public void setNdviMean(Float ndviMean) {
		this.ndviMean = ndviMean;
	}
	public Float getMoistureMeanMm() {
		return moistureMeanMm;
	}
	public void setMoistureMeanMm(Float moistureMeanMm) {
		this.moistureMeanMm = moistureMeanMm;
	}
	public Boolean getUpdated() {
		return Updated;
	}
	public void setUpdated(Boolean updated) {
		Updated = updated;
	}
	public Float getStressLevel() {
		return stressLevel;
	}
	public void setStressLevel(Float stressLevel) {
		this.stressLevel = stressLevel;
	}
	public Boolean getMeasurementAvailable() {
		return measurementAvailable;
	}
	public void setMeasurementAvailable(Boolean measurementAvailable) {
		this.measurementAvailable = measurementAvailable;
	}
	
	
}
