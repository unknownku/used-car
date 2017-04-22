package com.oot.usedcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oot.usedcar.domain.Car;
import com.oot.usedcar.domain.CarReservation;

public interface ReserveRepository extends JpaRepository<CarReservation, Long> {
	
	CarReservation findById(Long id);

}
