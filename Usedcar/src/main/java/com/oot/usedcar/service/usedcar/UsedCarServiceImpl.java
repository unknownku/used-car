package com.oot.usedcar.service.usedcar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oot.usedcar.domain.UsedCar;
import com.oot.usedcar.repository.UsedCarRepository;

@Service
public class UsedCarServiceImpl implements UsedCarService{

	@Autowired
	private UsedCarRepository usedCardRepository;
	
	@Override
	public void save(UsedCar usedCar) {
		usedCardRepository.save(usedCar);
	}

}
