package com.oot.usedcar.service;

import static org.junit.Assert.assertEquals;

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
	public void testCalculateDepreciationPrice() {
		assertEquals(new BigDecimal("100000.00"),this.estimatePriceService.calculateDepreciationPrice(2017, 1000000, false, false, 0));
	}
	
	@Test
	public void testCalculateEstimatePrice() {
		assertEquals(new BigDecimal("40000.00"),this.estimatePriceService.calculateEstimatePrice(new BigDecimal("100000.00"), new BigDecimal("10000.00")));
	}

}
