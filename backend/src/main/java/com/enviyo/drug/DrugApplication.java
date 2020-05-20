package com.enviyo.drug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication
@SpringBootApplication()
@EnableJpaRepositories(basePackages= {"com.enviyo.drug.dao"})
@EntityScan(basePackages= {"com.enviyo.drug.model"})
public class DrugApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DrugApplication.class, args);
	}
}
