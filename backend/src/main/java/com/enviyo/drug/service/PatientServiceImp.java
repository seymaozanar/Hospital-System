package com.enviyo.drug.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviyo.drug.dao.PatientDaoRepo;
import com.enviyo.drug.model.Patient;
import com.enviyo.drug.model.User;

@Service
public class PatientServiceImp implements PatientService {
	@Autowired
	PatientDaoRepo patientDaoRepo;

	@Override
	public List<Patient> getAllPatient(String id) {

		
		return patientDaoRepo.getAll(id);
		//return patientDaoRepo.findAll();
	}

	@Override
	public Patient savePatient(Patient patient) {

		return patientDaoRepo.save(patient);
	}

	public Optional<Patient> getById(String id) {
		// TODO Auto-generated method stub
		return patientDaoRepo.findById(id);
	}

	@Override
	public Patient getName(Patient patient) {
		return patientDaoRepo.getName(patient.getName());
	}

}
