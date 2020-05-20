package com.enviyo.drug.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.enviyo.drug.dao.DrugDaoRepo;
import com.enviyo.drug.model.Drug;

@Service
public class DrugServiceImpl  implements DrugService {

	@Autowired //	DrugDaoRepo drugDaoRepo=new DrugDaoRepo() yapmak yerine
	DrugDaoRepo drugDaoRepo;
	
	
	@Override
	public List<Drug> getAllDrugList() {
		// TODO Auto-generated method stub
		return drugDaoRepo.findAll();
	}

	@Override
	public Optional<Drug> getById(String id) {
		// TODO Auto-generated method stub
		return drugDaoRepo.findById(id);
	}
	@Override
	public Drug saveDrug(Drug drug) {
		return drugDaoRepo.save(drug);
		
	}
	@Override
	public void delete(String id) {
	   drugDaoRepo.deleteById(id);
	}


}
