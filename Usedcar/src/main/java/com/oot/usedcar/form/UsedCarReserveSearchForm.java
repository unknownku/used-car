package com.oot.usedcar.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UsedCarReserveSearchForm {
	
	private Long reserveId;
	
	@Pattern(regexp = "[a-zA-Z]{1,8}")
	private String name;

	public Long getReserveId() {
		return reserveId;
	}

	public void setReserveId(Long reserveId) {
		this.reserveId = reserveId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
