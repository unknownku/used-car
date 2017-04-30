package com.oot.usedcar.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UsedCars")
public class UsedCar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String color;
	private String carId;
	private String bookingCarId;
	private BigDecimal price;
	private int year;
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date receivingDate;
	private String brand;
	private String model;
	private String submodel;
	private int kilometer;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getBookingCarId() {
		return bookingCarId;
	}
	public void setBookingCarId(String bookingCarId) {
		this.bookingCarId = bookingCarId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getReceivingDate() {
		return receivingDate;
	}
	public void setReceivingDate(Date receivingDate) {
		this.receivingDate = receivingDate;
	}
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
	public String getSubmodel() {
		return submodel;
	}
	public void setSubmodel(String submodel) {
		this.submodel = submodel;
	}
	public int getKilometer() {
		return kilometer;
	}
	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}

	
	

}
