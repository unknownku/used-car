package com.oot.usedcar.form;

import java.math.BigDecimal;

public class EstimatePriceForm {

	private String brand;
	private String model;
	private String subModel;
	private int year;

	private int kilometer;
	private boolean isFlooding;
	private boolean isCrashing;
	private int scratchRate;
	private BigDecimal estimatePrice;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSubModel() {
		return subModel;
	}

	public void setSubModel(String subModel) {
		this.subModel = subModel;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getKilometer() {
		return kilometer;
	}

	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}

	public boolean isFlooding() {
		return isFlooding;
	}

	public void setFlooding(boolean isFlooding) {
		this.isFlooding = isFlooding;
	}

	public boolean isCrashing() {
		return isCrashing;
	}

	public void setCrashing(boolean isCrashing) {
		this.isCrashing = isCrashing;
	}

	public BigDecimal getEstimatePrice() {
		return estimatePrice;
	}

	public void setEstimatePrice(BigDecimal estimatePrice) {
		this.estimatePrice = estimatePrice;
	}

	public int getScratchRate() {
		return scratchRate;
	}

	public void setScratchRate(int scratchRate) {
		this.scratchRate = scratchRate;
	}

}
