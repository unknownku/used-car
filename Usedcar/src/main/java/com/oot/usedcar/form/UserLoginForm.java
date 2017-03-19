package com.oot.usedcar.form;

import javax.validation.constraints.Size;

public class UserLoginForm {
	
	@Size(min=4, max=35)
    private String username;
	@Size(min=4, max=35)
    private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
