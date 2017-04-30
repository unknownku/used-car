package com.oot.usedcar.form;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.oot.usedcar.domain.UsedCar;

public class ReserveForm {
	@NotNull
    @Size(min=2, max=30, message = "ชื่อห้ามเป็นค่าว่างและมีอย่างน้อย 2 ตัวอักษร")
	private String name;

	@NotNull
	@Size(min=1, message = "กรุณากรอกที่อยู่")
    private String address;
	
	@NotNull
	@Size(min=1, message = "กรุณากรอกหมายเลขโทรศัพท์")
    private String phoneNumber;

	@NotNull
	@Size(min=1, message = "กรุณากรอกหมายบัตรประชาชน")
    private String idCard;

	@NotNull
	@Size(min=1, message = "กรุณากรอกวิธีการชำระเงิน")
    private String payMethod;

	@Min(value = 1, message = "กรุณากรอกจำนวนเงินที่จอง")
	@NotNull(message = "กรุณากรอกจำนวนเงินที่จอง")
    private BigDecimal reservAmount;

	@NotNull
	@Size(min=1, message = "กรุณากรอกวันที่จอง")
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

}
