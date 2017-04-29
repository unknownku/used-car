package com.oot.usedcar.service.buycar;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

import com.oot.usedcar.domain.BuyCar;

public interface BuyCarService {
//	public BigDecimal calculateEstimatePrice(BigDecimal middlePrice, BigDecimal depreciationPrice);
	
	public List<BuyCar> findAll();
	
}
