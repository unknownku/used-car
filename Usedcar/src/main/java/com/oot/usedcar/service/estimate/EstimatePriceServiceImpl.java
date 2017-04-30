package com.oot.usedcar.service.estimate;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.oot.usedcar.constant.ConstantValue;

@Service
public class EstimatePriceServiceImpl implements EstimatePriceService {

	@Override
	public BigDecimal calculateEstimatePrice(BigDecimal middlePrice, BigDecimal depreciationPrice) {
		BigDecimal estimatePrice = new BigDecimal(ConstantValue.ZERO);
		BigDecimal margin = new BigDecimal(ConstantValue.USED_CAR_MAGIN);
		estimatePrice = middlePrice.subtract(margin).subtract(depreciationPrice);
		return estimatePrice;
	}

	@Override
	public BigDecimal calculateDepreciationPrice(int year, int kilometer, boolean isFlooding, boolean isCrashing,
			int scratchRate) {

		BigDecimal depreciationPrice = new BigDecimal(ConstantValue.ZERO);

		depreciationPrice = depreciationPrice.add(calculateYearDepreciationPrice(scratchRate));
		depreciationPrice = depreciationPrice.add(calculateKilometerDepreciationPrice(kilometer));
		depreciationPrice = depreciationPrice.add(calculateFloodingDepreciationPrice(isFlooding));
		depreciationPrice = depreciationPrice.add(calculateCrashingDepreciationPrice(isCrashing));

		return depreciationPrice;
	}

	private BigDecimal calculateCrashingDepreciationPrice(boolean isCrashing) {
		BigDecimal depreciationPrice = new BigDecimal(ConstantValue.ZERO);
		if (isCrashing) {
			depreciationPrice = depreciationPrice.add(new BigDecimal(ConstantValue.USED_CAR_CRASHING_PRICE));
		}
		return depreciationPrice;
	}

	private BigDecimal calculateFloodingDepreciationPrice(boolean isFlooding) {
		BigDecimal depreciationPrice = new BigDecimal(ConstantValue.ZERO);
		if (isFlooding) {
			depreciationPrice = depreciationPrice.add(new BigDecimal(ConstantValue.USED_CAR_FLOODING_PRICE));
		}
		return depreciationPrice;
	}

	private BigDecimal calculateYearDepreciationPrice(int scratchRate) {
		BigDecimal depreciationPrice = new BigDecimal(ConstantValue.ZERO);
		switch (scratchRate) {
		case 1:
			depreciationPrice = depreciationPrice.add(new BigDecimal(ConstantValue.SCRATCH_LOW_RATE));
			break;
		case 2:
			depreciationPrice = depreciationPrice.add(new BigDecimal(ConstantValue.SCRATCH_MEDIUM_RATE));
			break;
		case 3:
			depreciationPrice = depreciationPrice.add(new BigDecimal(ConstantValue.SCRATCH_HIGH_RATE));
			break;
		default:
			break;
		}
		return depreciationPrice;
	}

	private BigDecimal calculateKilometerDepreciationPrice(int kilometer) {
		BigDecimal depreciationPrice = new BigDecimal(ConstantValue.ZERO);
		BigDecimal temp = new BigDecimal(ConstantValue.ZERO);
		int multiply = kilometer / 10000;
		temp = new BigDecimal(ConstantValue.KILOMETER_RATE);
		temp = temp.multiply(new BigDecimal(multiply));
		return depreciationPrice.add(temp);
	}

}
