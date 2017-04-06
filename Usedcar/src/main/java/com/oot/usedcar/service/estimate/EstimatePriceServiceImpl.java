package com.oot.usedcar.service.estimate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

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
			int usingType) {

		BigDecimal depreciationPrice = new BigDecimal(ConstantValue.ZERO);

		depreciationPrice = depreciationPrice.add(calculateYearDepreciationPrice(year, usingType));
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

	private BigDecimal calculateYearDepreciationPrice(int year, int usingType) {
		BigDecimal depreciationPrice = new BigDecimal(ConstantValue.ZERO);
		BigDecimal temp = new BigDecimal(ConstantValue.ZERO);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date date = new Date();
		year = Integer.parseInt(sdf.format(date)) - year;
		switch (usingType) {
		case 0: // รถยนต์โดยสารส่วนบุคคล
			depreciationPrice.add(new BigDecimal(ConstantValue.USED_CAR_PERSONAL_PRICE));
			temp = new BigDecimal(ConstantValue.USED_CAR_PERSONAL_PRICE_PER_YEAR);
			temp = temp.multiply(new BigDecimal(year));
			break;
		case 1: // รถยนต์โดยสารเพื่อการพาณิชย์รับจ้าง
			depreciationPrice.add(new BigDecimal(ConstantValue.USED_CAR_COMMERCIAL_PRICE));
			temp = new BigDecimal(ConstantValue.USED_CAR_COMMERCIAL_PRICE_PER_YEAR);
			temp = temp.multiply(new BigDecimal(year));
			break;
		case 2: // รถยนต์บรรทุกเพื่อการพาณิชย์
			depreciationPrice.add(new BigDecimal(ConstantValue.USED_CAR_CARRY_PRICE));
			temp = new BigDecimal(ConstantValue.USED_CAR_CARRY_PRICE_PER_YEAR);
			temp = temp.multiply(new BigDecimal(year));
			break;
		default:
			depreciationPrice.add(new BigDecimal(ConstantValue.ZERO));
			break;
		}
		return depreciationPrice.add(temp);
	}

}
