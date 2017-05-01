package com.oot.usedcar.form;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.oot.usedcar.domain.UsedCar;

public class ReserveForm {
	@NotNull
    @Size(min=2, max=30, message = "Name not blank and at least 2 alphabets")
	private String name;

	@NotNull
	@Size(min=1, message = "Please fill in address")
    private String address;
	
	@NotNull
	@Size(min=1, message = "Please fill in phone number")
    private String phoneNumber;

	@NotNull
	@Size(min=1, message = "Please fill in ID card number")
    private String idCard;

	@NotNull
	@Size(min=1, message = "Please choose payment method")
    private String payMethod;

	@Min(value = 1, message = "Please fill in reservation amount")
	@NotNull(message = "Please fill in reservation amount")
	@Digits(integer=9, fraction=0, message = "Please fill not over 9 digits")   
    private BigDecimal reservAmount;

	@Min(value = 1, message = "Please fill in actual sale price")
	@NotNull(message = "Please fill in actual sale price")
	@Digits(integer=9, fraction=0, message = "Please fill not over 9 digits") 
    private BigDecimal actualSalePrice;
	
	@NotNull
	@Size(min=1, message = "Please fill in reserve date")
    private String reservDate;

    private String reservNo;
    
    private UsedCar reserveCar;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public BigDecimal getReservAmount() {
		return reservAmount;
	}

	public void setReservAmount(BigDecimal reservAmount) {
		this.reservAmount = reservAmount;
	}

	public String getReservDate() {
		return reservDate;
	}

	public void setReservDate(String reservDate) {
		this.reservDate = reservDate;
	}

	public String getReservNo() {
		return reservNo;
	}

	public void setReservNo(String reservNo) {
		this.reservNo = reservNo;
	}

	public UsedCar getReserveCar() {
		return reserveCar;
	}

	public void setReserveCar(UsedCar reserveCar) {
		this.reserveCar = reserveCar;
	}

	public BigDecimal getActualSalePrice() {
		return actualSalePrice;
	}

	public void setActualSalePrice(BigDecimal actualSalePrice) {
		this.actualSalePrice = actualSalePrice;
	}

	
}