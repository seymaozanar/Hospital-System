package com.enviyo.drug.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviyo.drug.model.Doctor;

@Repository
public interface DoctorDaoRepo extends JpaRepository<Doctor, String>{

}
