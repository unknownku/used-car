package com.oot.usedcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.oot.usedcar.domain.UsedCar;

public interface UsedCarRepository extends JpaRepository<UsedCar, Long>, JpaSpecificationExecutor<UsedCar> {

	UsedCar findByBrandAndModelAndSubmodelAndYearAndKilometer(String brand, String model, String submodel, int year, int kilometer);
	
	UsedCar findByid(Long id);

	List<UsedCar> findByBrandAndModelAndSubmodelAndYear(String brand, String model, String submodel, int year);
}
