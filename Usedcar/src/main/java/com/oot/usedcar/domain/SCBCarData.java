package com.oot.usedcar.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SCBCarData {

	private int id;
	private String vehicle_key;
	private String make_code;
	private String family_code;
	private int year;
	private String description;
	private BigDecimal price;
	private String created_at;
	private String updated_at;
	private boolean use_mc;
	private boolean use_nc;
	private boolean use_uc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicle_key() {
		return vehicle_key;
	}
	public void setVehicle_key(String vehicle_key) {
		this.vehicle_key = vehicle_key;
	}
	public String getMake_code() {
		return make_code;
	}
	public void setMake_code(String make_code) {
		this.make_code = make_code;
	}
	public String getFamily_code() {
		return family_code;
	}
	public void setFamily_code(String family_code) {
		this.family_code = family_code;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public boolean isUse_mc() {
		return use_mc;
	}
	public void setUse_mc(boolean use_mc) {
		this.use_mc = use_mc;
	}
	public boolean isUse_nc() {
		return use_nc;
	}
	public void setUse_nc(boolean use_nc) {
		this.use_nc = use_nc;
	}
	public boolean isUse_uc() {
		return use_uc;
	}
	public void setUse_uc(boolean use_uc) {
		this.use_uc = use_uc;
	}
	
	
	
}
