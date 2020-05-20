package com.enviyo.drug.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enviyo.drug.model.Doctor;
import com.enviyo.drug.service.DoctorService;

@CrossOrigin
@RestController
public class DoctorController {
	@Autowired
	DoctorService doctorService;

	@GetMapping("getAllDoctor")
	public List<Doctor> getAllDoctorList() {

		return doctorService.getAllDoctorList();
	}

	@GetMapping("getByName/{name}")
	public Optional<Doctor> getByName(@PathVariable String name) {

		return doctorService.getByName(name);

	}

	@GetMapping("getByBranch/{branch}")
	public Optional<Doctor> getByBranch(@PathVariable String branch) {

		return doctorService.getByBranch(branch);

	}

	@PostMapping(path = "/saveDoctor")
	public Doctor saveDoctor(@RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
	}

}
