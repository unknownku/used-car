package com.oot.usedcar.form;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BuyCarForm {
	@NotNull
    @Size(min=1, max=6, message = "Please select gender.")
	private String gender;
	
	@NotNull
    @Size(min=1, max=100, message = "Please input name")
	private String name;
	
	@NotNull
    @Size(min=1, max=100, message = "Please input lastname")
	private String lastname;
	
	
	private String address;
	private String phone;
	private Date date;	
	private Date licensedate;
	private String licenseNo;
	private String cartype;
	private String carstyle;
	private String carbrand;
	private String carmodel;
	private String caryear;
	private String carcolor;
	private String carno;
	private String carnoat;
	private String carenginebrand;
	private String carengineno;
	private String carenginenoat;
	private String fueltype;
	private String gascylinno;
	private String pistonno;
	private Integer carcc;
	private Integer carhotpower;
	private String caretc;
	private Double carweight;
	private Integer carseats;
	private BigDecimal price;
	

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getLicensedate() {
		return licensedate;
	}
	public void setLicensedate(Date licensedate) {
		this.licensedate = licensedate;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getCarstyle() {
		return carstyle;
	}
	public void setCarstyle(String carstyle) {
		this.carstyle = carstyle;
	}
	public String getCarbrand() {
		return carbrand;
	}
	public void setCarbrand(String carbrand) {
		this.carbrand = carbrand;
	}
	public String getCarmodel() {
		return carmodel;
	}
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	public String getCaryear() {
		return caryear;
	}
	public void setCaryear(String caryear) {
		this.caryear = caryear;
	}
	public String getCarcolor() {
		return carcolor;
	}
	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public String getCarnoat() {
		return carnoat;
	}
	public void setCarnoat(String carnoat) {
		this.carnoat = carnoat;
	}
	public String getCarenginebrand() {
		return carenginebrand;
	}
	public void setCarenginebrand(String carenginebrand) {
		this.carenginebrand = carenginebrand;
	}
	public String getCarengineno() {
		return carengineno;
	}
	public void setCarengineno(String carengineno) {
		this.carengineno = carengineno;
	}
	public String getCarenginenoat() {
		return carenginenoat;
	}
	public void setCarenginenoat(String carenginenoat) {
		this.carenginenoat = carenginenoat;
	}
	public String getFueltype() {
		return fueltype;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	public String getGascylinno() {
		return gascylinno;
	}
	public void setGascylinno(String gascylinno) {
		this.gascylinno = gascylinno;
	}
	public String getPistonno() {
		return pistonno;
	}
	public void setPistonno(String pistonno) {
		this.pistonno = pistonno;
	}
	public Integer getCarcc() {
		return carcc;
	}
	public void setCarcc(Integer carcc) {
		this.carcc = carcc;
	}
	public Integer getCarhotpower() {
		return carhotpower;
	}
	public void setCarhotpower(Integer carhotpower) {
		this.carhotpower = carhotpower;
	}
	public String getCaretc() {
		return caretc;
	}
	public void setCaretc(String caretc) {
		this.caretc = caretc;
	}
	public Double getCarweight() {
		return carweight;
	}
	public void setCarweight(Double carweight) {
		this.carweight = carweight;
	}
	public Integer getCarseats() {
		return carseats;
	}
	public void setCarseats(Integer carseats) {
		this.carseats = carseats;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	

}
