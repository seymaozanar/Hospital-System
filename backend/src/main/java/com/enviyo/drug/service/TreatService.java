package com.enviyo.drug.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enviyo.drug.model.DrugPercentageDTO;
import com.enviyo.drug.model.Treat;

@Service
public interface TreatService {
	
	Optional<Treat> getBySituation(String id);
	Treat saveTreat (Treat treat);
	List<Treat> getTreatList(String userId);
	List<Treat> getAllTreatList();
	List<DrugPercentageDTO> getPercent();
	}
