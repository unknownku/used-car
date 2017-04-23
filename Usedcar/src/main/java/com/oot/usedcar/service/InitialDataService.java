package com.oot.usedcar.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oot.usedcar.domain.BuyCar;
import com.oot.usedcar.domain.Car;
import com.oot.usedcar.domain.UsedCar;
import com.oot.usedcar.domain.User;
import com.oot.usedcar.repository.CarRepository;
import com.oot.usedcar.repository.UsedCarRepository;
import com.oot.usedcar.service.user.UserService;
import com.oot.usedcar.repository.BuyCarRepository;;

@Service
public class InitialDataService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private BuyCarRepository buyCarRepository;
	
	@Autowired
	private UsedCarRepository usedCarRepository;
	
	
	public void initailUser(){
		User user = new User(); 
    	user.setUsername("test");
    	user.setPassword("test");
    	userService.save(user);
	}
	
	public void initailCar(){
		Car car = new Car();
		car.setBrand("TOYOTA");
		car.setModel("Altis");
		car.setYear(2015);
		car.setMiddlePrice(new BigDecimal("500000.00"));
		carRepository.save(car);
	}
	
	public void initailUsedCar(){
		UsedCar used_car = new UsedCar();
		used_car.setBrand("HONDA");
		used_car.setModel("Jazz");
		used_car.setSubmodel("E");
		used_car.setYear(2015);
		used_car.setKilometer(100000);
		usedCarRepository.save(used_car);
	}
	

	public void initailBuyCar(){
		BuyCar buycar = new BuyCar();
		buycar.setCustomerId("100101");
		buycar.setName("KITTI");
		buycar.setLastname("Hongsa");
//		buycar.setBuyDate("");
//		buycar.setBuyPrice(300000);
		buyCarRepository.save(buycar);
		
		
	}
	
	public List<Car> getCarList(){
		List<Car> carList = new ArrayList();
		Car car = new Car();
		car.setBrand("TOYOTA");
		car.setModel("Altis");
		car.setYear(2015);
		car.setMiddlePrice(new BigDecimal("500000.00"));
		carList.add(car);
		
		Car car2 = new Car();
		car2.setBrand("HONDA");
		car2.setModel("CIVIC");
		car2.setYear(2015);
		car2.setMiddlePrice(new BigDecimal("500000.00"));
		carList.add(car2);
		
		return carList;
	}
}
