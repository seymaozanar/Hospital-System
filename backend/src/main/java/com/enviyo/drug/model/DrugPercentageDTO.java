package com.enviyo.drug.model;

import java.math.BigDecimal;

public class DrugPercentageDTO {

	private Drug drug;

	private String situation;

	private Long times;

	public DrugPercentageDTO(Drug drug, String situation, Long times) {
		this.drug = drug;
		this.situation = situation;
		this.times = times;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public Long getTimes() {
		return times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}

}
