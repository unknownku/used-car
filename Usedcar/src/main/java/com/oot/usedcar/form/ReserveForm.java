package com.oot.usedcar.form;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Size;

import com.oot.usedcar.domain.Car;

public class ReserveForm {
	
	private String name;

    private String address;
	
    private String phoneNumber;

    private String idCard;

    private String payMethod;

    private BigDecimal reservAmount;

    private Date reservDate;

    private String reservNo;
    
    private Car reserveCar;

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

	public Date getReservDate() {
		return reservDate;
	}

	public void setReservDate(Date reservDate) {
		this.reservDate = reservDate;
	}

	public String getReservNo() {
		return reservNo;
	}

	public void setReservNo(String reservNo) {
		this.reservNo = reservNo;
	}

	public Car getReserveCar() {
		return reserveCar;
	}

	public void setReserveCar(Car reserveCar) {
		this.reserveCar = reserveCar;
	}
	
	
}
