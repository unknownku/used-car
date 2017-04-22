package com.oot.usedcar.service.car;

import com.oot.usedcar.domain.Car;
import com.oot.usedcar.domain.UsedCar;

public interface UsedCarService {

	public void save(UsedCar used_car);
	public UsedCar findByBrandAndModelAndSubmodelAndYearAndKilometer
	(String brand, String model, String submodel, int year, int kilometer);
}
