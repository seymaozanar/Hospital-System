package com.enviyo.drug.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviyo.drug.model.Disease;

@Repository
public interface DiseaseDaoRepo extends JpaRepository<Disease, String>{

}
