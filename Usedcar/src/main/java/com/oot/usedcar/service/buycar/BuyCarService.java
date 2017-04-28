package com.oot.usedcar.service.buycar;

import java.math.BigDecimal;

public interface BuyCarService {
	public BigDecimal calculateEstimatePrice(BigDecimal middlePrice, BigDecimal depreciationPrice);
}
