package com.enviyo.drug.service;

import java.util.List;
import java.util.Optional;
import com.enviyo.drug.model.Drug;


public interface DrugService {

	List<Drug> getAllDrugList();

	Optional<Drug> getById(String id);

	Drug saveDrug(Drug drug);

	void delete(String id);


}
