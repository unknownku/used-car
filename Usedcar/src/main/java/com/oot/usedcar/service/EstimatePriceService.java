package com.oot.usedcar.service;

import java.math.BigDecimal;

import com.oot.usedcar.domain.Car;

public interface EstimatePriceService {
	
	public BigDecimal calculateEstimatePrice(BigDecimal middlePrice, BigDecimal depreciationPrice);
	public BigDecimal calculateDepreciationPrice(int year, int kilometer, boolean isFlood, boolean isCrashing, int usingType);
}
