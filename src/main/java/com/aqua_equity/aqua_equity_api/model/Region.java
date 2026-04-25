package com.aqua_equity.aqua_equity_api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "region")
public class Region {
	
	private Long id;
	private String regionName;
	private List<Farm> farmList;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "region_id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "region_name", nullable = false, unique = true)
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	@OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
	public List<Farm> getFarmList() {
		return farmList;
	}
	public void setFarmList(List<Farm> farmList) {
		this.farmList = farmList;
	}
	
	
	
}
