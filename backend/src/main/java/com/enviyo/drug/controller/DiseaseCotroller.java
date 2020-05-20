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

import com.enviyo.drug.model.Disease;
import com.enviyo.drug.service.DiseaseService;

@CrossOrigin
@RestController
public class DiseaseCotroller {
	@Autowired
	DiseaseService diseaseService;

	@GetMapping("getDiseases")
	public List<Disease> getDiseasesList() {
		return diseaseService.getDiseaseList();
	}

	@GetMapping("getByIdDisease/{id}")
	public Optional<Disease> getByIdDisease(@PathVariable String id) {

		return diseaseService.getByIdDisease(id);
	}

	@PostMapping(path = "/saveDisease")
	public Disease saveDisease(@RequestBody Disease disease) {
		return diseaseService.saveDisease(disease);
	}

	@PostMapping("/deleteDisease/{id}")
	public void deleteDisease(@PathVariable String id) {
		diseaseService.deleteDisease(id);
	}
}
