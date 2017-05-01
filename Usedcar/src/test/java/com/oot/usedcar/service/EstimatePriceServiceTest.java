package com.oot.usedcar.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oot.usedcar.service.estimate.EstimatePriceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstimatePriceServiceTest {

	@Autowired
	EstimatePriceService estimatePriceService;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testCalculateDepreciationPriceNoFloodingNoCrashingNoScratching() {
		BigDecimal expected = new BigDecimal("50000.00");
		BigDecimal actual = this.estimatePriceService.calculateDepreciationPrice(500000, false, false, 0);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateDepreciationPriceFloodingNoCrashingNoScratching() {
		BigDecimal expected = new BigDecimal("100000.00");
		BigDecimal actual = this.estimatePriceService.calculateDepreciationPrice(500000, true, false, 0);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateDepreciationPriceNoFloodingCrashingNoScratching() {
		BigDecimal expected = new BigDecimal("150000.00");
		BigDecimal actual = this.estimatePriceService.calculateDepreciationPrice(500000, false, true, 0);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateDepreciationPriceFloodingCrashingNoScratching() {
		BigDecimal expected = new BigDecimal("200000.00");
		BigDecimal actual = this.estimatePriceService.calculateDepreciationPrice(500000, true, true, 0);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateDepreciationPriceNoFloodingNoCrashingLowScratching() {
		BigDecimal expected = new BigDecimal("60000.00");
		BigDecimal actual = this.estimatePriceService.calculateDepreciationPrice(500000, false, false, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateDepreciationPriceNoFloodingNoCrashingMediumScratching() {
		BigDecimal expected = new BigDecimal("70000.00");
		BigDecimal actual = this.estimatePriceService.calculateDepreciationPrice(500000, false, false, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateDepreciationPriceNoFloodingNoCrashingHighScratching() {
		BigDecimal expected = new BigDecimal("80000.00");
		BigDecimal actual = this.estimatePriceService.calculateDepreciationPrice(500000, false, false, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateEstimatePriceMiddlePriceMoreThanDepreciationPrice() {
		BigDecimal middlePrice = new BigDecimal("100000.00");
		BigDecimal depreciationPrice = new BigDecimal("10000.00");
		BigDecimal expected = new BigDecimal("40000.00");
		BigDecimal actual = this.estimatePriceService.calculateEstimatePrice(middlePrice, depreciationPrice);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateEstimatePriceDepreciationPriceMoreThanMiddlePrice() {
		BigDecimal middlePrice = new BigDecimal("100000.00");
		BigDecimal depreciationPrice = new BigDecimal("200000.00");
		BigDecimal expected = new BigDecimal("-150000.00");
		BigDecimal actual = this.estimatePriceService.calculateEstimatePrice(middlePrice, depreciationPrice);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateEstimatePriceMiddlePriceEqualDepreciationPrice() {
		BigDecimal middlePrice = new BigDecimal("100000.00");
		BigDecimal depreciationPrice = new BigDecimal("100000.00");
		BigDecimal expected = new BigDecimal("-50000.00");
		BigDecimal actual = this.estimatePriceService.calculateEstimatePrice(middlePrice, depreciationPrice);
		assertEquals(expected, actual);
	}
	
	

}
