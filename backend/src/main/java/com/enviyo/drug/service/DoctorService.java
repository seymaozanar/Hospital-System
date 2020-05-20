package com.enviyo.drug.service;



import java.util.List;
import java.util.Optional;

import com.enviyo.drug.model.Doctor;

public interface  DoctorService {

	Optional<Doctor> getByName(String name);
	Optional<Doctor> getByBranch(String branch);
	List<Doctor> getAllDoctorList();
	Doctor saveDoctor(Doctor doctor);
	

	

}
