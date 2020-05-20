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

import com.enviyo.drug.model.Drug;
import com.enviyo.drug.service.DrugService;

@CrossOrigin
@RestController
public class DrugController {

	@Autowired
	DrugService drugService;

	@GetMapping("getAll")
	public List<Drug> getAllDrugList() {

		return drugService.getAllDrugList();
	}

	@GetMapping("getById/{id}")
	public Optional<Drug> getById(@PathVariable String id) {

		return drugService.getById(id);

	}

	@PostMapping(path = "/save")
	public Drug postDeneme(@RequestBody Drug drug) {
		return drugService.saveDrug(drug);
	}

	@PostMapping("/delete/{id}")
	public void delete(@PathVariable String id) {
		drugService.delete(id);
	}

}
