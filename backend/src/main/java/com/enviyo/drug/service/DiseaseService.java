package com.enviyo.drug.service;

import java.util.List;
import java.util.Optional;

import com.enviyo.drug.model.Disease;


public interface DiseaseService {
	List<Disease> getDiseaseList();

	Optional<Disease> getByIdDisease(String id);

	Disease saveDisease(Disease disease);

	void deleteDisease(String id);
}
