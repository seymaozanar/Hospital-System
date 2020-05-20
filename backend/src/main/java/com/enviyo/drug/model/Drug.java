package com.enviyo.drug.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="drug",schema="grupa")
public class Drug {
	
	@Id
    @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@Column(name="drug_id")
	private String drugId;
	
	@Column(name="drug_name")
	private String drugName;
	
	@OneToOne
	@JoinColumn(name="doctor",referencedColumnName="id")
	private User user;
	
	

	
 
	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	

}
