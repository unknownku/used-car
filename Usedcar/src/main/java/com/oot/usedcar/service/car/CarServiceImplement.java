package com.oot.usedcar.service.car;

import java.util.List;

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

	@Override
	public Car findById(Long id) {
		return carRepository.findById(id);
	}

	@Override
	public List<Car> findAll() {
		return carRepository.findAll();
	}

	@Override
	public Car findByBrandAndModelAndSubModelAndYear(String brand, String model, String subModel, int year) {
		return carRepository.findByBrandAndModelAndSubModelAndYear(brand, model, subModel, year);
	}

	@Override
	public List<String> findBrand() {
		return carRepository.findBrand();
	}

	@Override
	public List<String> findModel(String brand) {
		return carRepository.findModel(brand);
	}

	@Override
	public List<String> findSubModel(String brand, String model) {
		return carRepository.findSubModel(brand, model);
	}

	@Override
	public List<String> findYear(String brand, String model, String subModel) {
		return carRepository.findYear(brand, model, subModel);
	}

}
