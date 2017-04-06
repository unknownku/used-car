package com.oot.usedcar.service.security;

public interface SecurityService {
	public String findLoggedInUsername();
	public void autologin(String username, String password);
}
