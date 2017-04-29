package com.oot.usedcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oot.usedcar.domain.UsedCar;

public interface UsedCarRepository extends JpaRepository<UsedCar, Long> {

	UsedCar findByBrandAndModelAndSubmodelAndYearAndKilometer(String brand, String model, String submodel, int year, int kilometer);
	
	
	UsedCar findByid(Long id);
}
