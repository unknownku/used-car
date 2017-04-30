package com.oot.usedcar.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BuyCar")

public class BuyCar {

	private Long id;
	private String gender;
	private String cusid;
	private String name;
	private String lastname;
	private String address;
	private String phone;
	

	@Column(name="buydate", columnDefinition="buydate DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date buydate;	
	
	
	private Date licensedate;
	private String licenseNo;
	private String cartype;
	private String carstyle;
	private String carbrand;
	private String carmodel;
	private String carmodelsub;
	private int caryear;
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
	
	private String licenseplate;
	private String licenseprovince;
	private BigDecimal price;
	private int kilometer;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

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

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicenseplate() {
		return licenseplate;
	}

	public void setLicenseplate(String licenseplate) {
		this.licenseplate = licenseplate;
	}

	public String getCarmodelsub() {
		return carmodelsub;
	}

	public void setCarmodelsub(String carmodelsub) {
		this.carmodelsub = carmodelsub;
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

	public int getKilometer() {
		return kilometer;
	}

	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}

	
}

