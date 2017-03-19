package com.oot.usedcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oot.usedcar.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
