package com.oot.usedcar.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oot.usedcar.domain.Car;
import com.oot.usedcar.domain.User;
import com.oot.usedcar.repository.CarRepository;
import com.oot.usedcar.repository.UserRepository;

@Service
public class InitialDataService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	
	public void initailUser(){
		User user = new User();
    	user.setUsername("test");
    	user.setPassword("test");
        userRepository.save(user);
	}
	
	public void initailCar(){
		Car car = new Car();
		car.setBrand("TOYOTA");
		car.setModel("Altis");
		car.setYear(2015);
		car.setMiddlePrice(new BigDecimal("500000.00"));
		carRepository.save(car);
	}
	

}
