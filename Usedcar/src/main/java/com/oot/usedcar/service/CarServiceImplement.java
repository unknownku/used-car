package com.oot.usedcar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oot.usedcar.domain.Car;
import com.oot.usedcar.repository.CarRepository;

@Service
public class CarServiceImplement implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public void save(Car car) {
		carRepository.save(car);
	}

	@Override
	public Car findByBrand(String brand) {
		return carRepository.findByBrand(brand);
	}

	@Override
	public Car findByModel(String model) {
		return carRepository.findByModel(model);
	}

	@Override
	public Car findBySubModel(String subModel) {
		return carRepository.findBySubModel(subModel);
	}

	@Override
	public Car findByYear(int year) {
		return carRepository.findByYear(year);
	}

	@Override
	public Car findByBrandAndModelAndYear(String brand, String model, int year) {
		return carRepository.findByBrandAndModelAndYear(brand, model, year);
	}

}
