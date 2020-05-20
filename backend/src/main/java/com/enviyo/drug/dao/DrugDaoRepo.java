package com.enviyo.drug.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviyo.drug.model.Drug;

@Repository
public interface DrugDaoRepo extends JpaRepository<Drug, String>{

}
