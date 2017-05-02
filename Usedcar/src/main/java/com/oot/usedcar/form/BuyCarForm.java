package com.oot.usedcar.form;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class BuyCarForm {
	@NotNull
    @Size(min=1, max=6, message = "Please select gender.")
	private String gender;
	
	@NotNull
    @Size(min=1, message = "Please input identification card number.")
	private String cusid;
	
	@NotNull
    @Size(min=1, max=100, message = "Please input name")
	private String name;
	
	@NotNull
    @Size(min=1, max=100, message = "Please input lastname")
	private String lastname;
	
	@NotNull
    @Size(min=1, max=500, message = "Please input address")
	private String address;
	
	@NotNull
    @Size(min=1, message = "Please input phone number")
	private String phone;
	
	private Date buydate;	

	@NotNull
	@Size(min=1, message = "Plese select car license date")	
	private String licensedate;
	
	
	private String licenseNo;
	private String cartype;
	private String carstyle;
	
	
	
	@NotNull
    @Size(min=1, max=100, message = "Please select used car brand")
	private String carbrand;

	@NotNull
    @Size(min=1, max=100, message = "Please input used car model")
	private String carmodel;

	@NotNull
    @Size(min=1, max=100, message = "Please input used car sub model")
	private String carmodelsub;
	
	
	@Min(value = 1, message = "Please input used car year")
	@NotNull(message = "Please input used car year")	
	private int caryear;

	@NotNull
    @Size(min=1, max=100, message = "Please input used car color")
	private String carcolor;
	
	
	private String carno;
	private String carnoat;
	private String carenginebrand;
	private String carengineno;
	private String carenginenoat;
	private String fueltype;
	private String gascylinno;
	private String pistonno;
	
	private String carcc;
	private String carhotpower;
	private String caretc;
	private String carweight;
	private Integer carseats;
	
	
//	@Min(value = 1, message = "Please input used car buying price")
//	@NotNull(message = "Please input used car buying price")	
//	@Digits(integer=9, fraction=0, message = "Please fill not over 9 digits")   
//	private BigDecimal price;
	
	@NotNull
    @Size(min=1, max=15, message = "Please input used car buying price")
	private String price;
	
	@NotNull
    @Size(min=1, max=10, message = "Please input license plate number")
	private String licenseplate;
	
	@NotNull
    @Size(min=1, max=100, message = "Please input license plate province")
	private String licenseprovince;
	
//	@Min(value = 1, message = "Please input used car kilometer")
	@NotNull
	@Size(min=1, max=15, message = "Please input used car kilometer")
	private String kilometer;

	
	private String validate;
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
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

	
	public Date getBuydate() {
		return buydate;
	}
	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}

	public String getLicensedate() {
		return licensedate;
	}
	public void setLicensedate(String licensedate) {
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
	public String getCarmodelsub() {
		return carmodelsub;
	}
	public void setCarmodelsub(String carmodelsub) {
		this.carmodelsub = carmodelsub;
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
	public String getCarcc() {
		return carcc;
	}
	public void setCarcc(String carcc) {
		this.carcc = carcc;
	}
	public String getCarhotpower() {
		return carhotpower;
	}
	public void setCarhotpower(String carhotpower) {
		this.carhotpower = carhotpower;
	}
	public String getCaretc() {
		return caretc;
	}
	public void setCaretc(String caretc) {
		this.caretc = caretc;
	}
	public String getCarweight() {
		return carweight;
	}
	public void setCarweight(String carweight) {
		this.carweight = carweight;
	}
	public Integer getCarseats() {
		return carseats;
	}
	public void setCarseats(Integer carseats) {
		this.carseats = carseats;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getLicenseplate() {
		return licenseplate;
	}
	public void setLicenseplate(String licenseplate) {
		this.licenseplate = licenseplate;
	}

	public String getLicenseprovince() {
		return licenseprovince;
	}
	public void setLicenseprovince(String licenseprovince) {
		this.licenseprovince = licenseprovince;
	}
	
	public int getCaryear() {
		
		return caryear;
	}
	public void setCaryear(int caryear) {
		this.caryear = caryear;
	}
	
	
	public String getKilometer() {
		return kilometer;
	}
	public void setKilometer(String kilometer) {
		this.kilometer = kilometer;
	}
	
	public String getStatus() {
		return "Available";
	}
	
	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
	
	
}
