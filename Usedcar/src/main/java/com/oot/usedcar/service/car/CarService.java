package com.oot.usedcar.service.car;

import java.util.List;

import com.oot.usedcar.domain.Car;

public interface CarService {

	public void save(Car car);

	public Car findByBrand(String brand);

	public Car findByModel(String model);

	public Car findBySubModel(String subModel);

	public Car findByYear(int year);

	public Car findByBrandAndModelAndYear(String brand, String model, int year);

	public Car findByBrandAndModelAndSubModelAndYear(String brand, String model, String subModel, int year);

	public List<Car> findDistinctCarByBrand(String brand);

	public List<Car> findDistinctCarByBrandAndModel(String brand, String model);

	public List<Car> findDistinctCarByBrandAndModelAndSubModel(String brand, String model, String subModel);

	public List<Car> findDistinctCarByBrandAndModelAndSubModelAndYear(String brand, String model, String subModel,
			int year);

	public List<Car> findAll();

	public Car findById(Long id);

	public List<String> findBrand();

	public List<String> findModel(String brand);

	public List<String> findSubModel(String brand, String model);

	public List<String> findYear(String brand, String model, String subModel);

}
