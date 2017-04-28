package com.oot.usedcar.service.sellcar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oot.usedcar.domain.SellCar;
import com.oot.usedcar.repository.SellCarRepository;


@Service
public class SellCarServiceImpl implements SellCarService{
	@Autowired
	private SellCarRepository sellCarRepository;
	
	@Override
	public void save(SellCar sellCar) {
		sellCarRepository.save(sellCar);
	}
}
