package com.oot.usedcar.service.buycar;

import java.math.BigDecimal;
import com.oot.usedcar.domain.Car;

public interface BuyCarService {
	public BigDecimal calculateEstimatePrice(BigDecimal middlePrice, BigDecimal depreciationPrice);
}
