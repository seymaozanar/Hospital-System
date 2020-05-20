package com.enviyo.drug.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviyo.drug.dao.DoctorDaoRepo;

import com.enviyo.drug.model.Doctor;


@Service
public class DoctorServiceImp implements DoctorService {
   @Autowired
   DoctorDaoRepo doctorDaoRepo;
   
	@Override
	public Optional<Doctor> getByName(String name) {
		return null;
	}
	@Override
	public Optional<Doctor> getByBranch(String branch) {
		return null;
	}
	@Override
	public List<Doctor> getAllDoctorList() {
		return doctorDaoRepo.findAll();
	}
	@Override
	public Doctor saveDoctor(Doctor doctor) {
		
		return doctorDaoRepo.save(doctor);
	}

}
