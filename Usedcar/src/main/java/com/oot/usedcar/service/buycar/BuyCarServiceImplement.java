package com.oot.usedcar.service.buycar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oot.usedcar.domain.BuyCar;
import com.oot.usedcar.repository.BuyCarRepository;

@Service
public class BuyCarServiceImplement implements BuyCarService {

	@Autowired
	private BuyCarRepository buyCarRepository;
	
//	@Override
//	public BigDecimal calculateEstimatePrice(BigDecimal middlePrice, BigDecimal depreciationPrice) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<BuyCar> findAll() {
		// TODO Auto-generated method stub
		return buyCarRepository.findAll();
	}
		
}
