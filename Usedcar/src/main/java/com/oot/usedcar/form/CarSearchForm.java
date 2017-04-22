package com.oot.usedcar.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CarSearchForm {
	
	@Pattern(regexp = "[a-zA-Z]{1,8}")
	@NotNull
	private String brand;
	
	@Pattern(regexp = "[a-zA-Z]{1,8}")
	private String model;
	private String subModel;
	private int year;
	private int kilometer;


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

}
