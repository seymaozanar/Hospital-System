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
import com.enviyo.drug.model.Patient;
import com.enviyo.drug.service.PatientService;

@CrossOrigin
@RestController
public class PatientController {
	@Autowired
	PatientService patientService;

	@GetMapping("getAllPatient/{user}")
	public List<Patient> getAllPatient(@PathVariable("user") String Id) {

		return patientService.getAllPatient(Id);
	}

	@PostMapping(path = "/savePatient")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}
	
	@GetMapping("getByIdPatient/{id}")
	public Optional<Patient> getById(@PathVariable String id) {

		return patientService.getById(id);

	}
	
	
	
}
