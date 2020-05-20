package com.enviyo.drug.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enviyo.drug.model.DrugPercentageDTO;
import com.enviyo.drug.model.Treat;

@Repository
public interface TreatDaoRepo  extends JpaRepository<Treat,String > {
	
	@Query(value="SELECT p FROM Treat p WHERE doctor = ?1")
	List<Treat> getUser(String id);
 
	
			
//	@Query(nativeQuery=true , value= "Select a.drug, COUNT(*), SUM(a.ratio), ((sum(a.ratio)::real) / count(*) * 100) AS percent"
//         +"  FROM("+
//        			"Select drug, situation, (case when situation='Successful' then 1 else 0 end) AS ratio 	from grupa.'treat'"+
//        		")a GROUP BY  a.drug")
//	
//	List<Rate> getPercent();
 

	@Query(value="SELECT  new com.enviyo.drug.model.DrugPercentageDTO ("
			+ "    t.drug  , t.situation ,COUNT(*) as times"
			+ " ) FROM Treat  t GROUP BY  t.drug ,  t.situation")
	List<DrugPercentageDTO> getPercent();

}
