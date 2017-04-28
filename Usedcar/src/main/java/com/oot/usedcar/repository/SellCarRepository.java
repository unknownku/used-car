package com.oot.usedcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oot.usedcar.domain.SellCar;

public interface SellCarRepository extends JpaRepository<SellCar, Long> {
	SellCar findById(Long id);
}
