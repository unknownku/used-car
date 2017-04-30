package com.oot.usedcar.service.usedcar;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.oot.usedcar.domain.UsedCar;

public interface UsedCarService {
	public void save(UsedCar used_car);
	public List<UsedCar> findAll();
	
	public UsedCar findByBrandAndModelAndSubmodelAndYearAndKilometer
	(String brand, String model, String submodel, int year, int kilometer);
	
	public UsedCar findById(Long id);
	public List<UsedCar> findByBrandAndModelAndSubmodelAndYear
	(String brand, String model, String submodel, int year);
}
