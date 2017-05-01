package com.oot.usedcar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oot.usedcar.domain.UsedCar;
import com.oot.usedcar.service.usedcar.UsedCarService;

@RestController
public class JSONController {
	
	@Autowired
	UsedCarService usedCarService;
	
	@PostMapping("/usedCarDetail")
	public ResponseEntity getUsedCarDetail(@RequestParam String id) {
		
		UsedCar used_car = usedCarService.findById(Long.parseLong(id));
		
		if (used_car == null) {
			return new ResponseEntity("No Usedcar found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(used_car, HttpStatus.OK);
	}
}
