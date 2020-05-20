package com.enviyo.drug.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enviyo.drug.model.Patient;
import com.enviyo.drug.model.User;

@Repository
public interface PatientDaoRepo extends JpaRepository<Patient,String > {
	
	@Query(value="SELECT u FROM Patient u WHERE name = ?1")
	Patient getName(String name);

	@Query(value="SELECT p FROM Patient p WHERE doctor = ?1")
	List<Patient> getAll(String id);
	
}