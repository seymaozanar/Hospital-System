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
@Table(name = "patient", schema = "grupa")
public class Patient {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id")
	private String id;

	// aslında bu doctor

	

    @OneToOne
	@JoinColumn(name="doctor",columnDefinition="doctor",referencedColumnName="id")
	private User user;


	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;
 
	@Column(name="gender")
	private String gender;
 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
}
