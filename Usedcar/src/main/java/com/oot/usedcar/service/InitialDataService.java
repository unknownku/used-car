package com.oot.usedcar.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.oot.usedcar.domain.BuyCar;
import com.oot.usedcar.domain.Car;
import com.oot.usedcar.domain.SCBCar;
import com.oot.usedcar.domain.SCBCarData;
import com.oot.usedcar.domain.UsedCar;
import com.oot.usedcar.domain.User;
import com.oot.usedcar.repository.BuyCarRepository;
import com.oot.usedcar.repository.CarRepository;
import com.oot.usedcar.repository.UsedCarRepository;
import com.oot.usedcar.service.user.UserService;;

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
	
	private List<String> fileList = null;
	public void initailUser(){
		User user = new User(); 
    	user.setUsername("test");
    	user.setPassword("test");
    	userService.save(user);
	}
	
	public void initailCar(){
		this.fileList = new ArrayList<>();
		String sourceFolder = "/Users/apichart/Documents/Eclipse/workspace/ootproject/used-car/Usedcar/CAR/";
		List<String> fileList = generateFileList(new File(sourceFolder), sourceFolder);
		fileList.remove(0);
        for (String file : fileList) {
			String filename = sourceFolder+file;
			try {		
				Gson gson = new Gson();
				SCBCar scbCarToyota = gson.fromJson(new FileReader(filename), SCBCar.class);
				List<SCBCarData> scbCarDataListToyota = scbCarToyota.getData();
				for (SCBCarData scbCarData : scbCarDataListToyota) {
					Car car = new Car();
					car.setBrand(scbCarData.getMake_code());
					car.setModel(scbCarData.getFamily_code());
					car.setSubModel(scbCarData.getDescription());
					car.setYear(scbCarData.getYear());
					car.setMiddlePrice(scbCarData.getPrice());
					carRepository.save(car);
				}
			} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
				e.printStackTrace();
			}
				
		}
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
	
	private List<String> generateFileList(File node, String sourceFolder) {
        if (node.isFile()) {
        	this.fileList.add(generateFilePath(node.getAbsoluteFile().toString(), sourceFolder));
        }
        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename : subNote) {
                generateFileList(new File(node, filename), sourceFolder);
            }
        }
        return this.fileList;
    }
	
	private String generateFilePath(String file, String sourceFolder) {
        return file.substring(sourceFolder.length(), file.length());
    }
}
