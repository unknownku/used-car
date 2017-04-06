package com.oot.usedcar.service.user;

import com.oot.usedcar.domain.User;

public interface UserService {
	public void save(User user);
	public User findByUsername(String username);
}
