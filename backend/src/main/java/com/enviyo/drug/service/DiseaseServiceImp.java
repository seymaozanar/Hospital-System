package com.enviyo.drug.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviyo.drug.dao.DiseaseDaoRepo;
import com.enviyo.drug.model.Disease;

@Service
public class DiseaseServiceImp implements DiseaseService {
    @Autowired
	DiseaseDaoRepo diseaseDaoRepo;

	@Override
	public List<Disease> getDiseaseList() {
		// TODO Auto-generated method stub
		return diseaseDaoRepo.findAll();
	}

	@Override
	public Optional<Disease> getByIdDisease (String id) {
		// TODO Auto-generated method stub
		return diseaseDaoRepo.findById(id) ;
	}

	@Override
	public Disease saveDisease(Disease disease) {
		return diseaseDaoRepo.save(disease);
	}

	@Override
	public void deleteDisease(String id) {
		diseaseDaoRepo.deleteById(id);;
		
	}

	
}
