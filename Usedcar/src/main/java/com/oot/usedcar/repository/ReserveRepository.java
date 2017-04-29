package com.oot.usedcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.oot.usedcar.domain.CarReservation;

public interface ReserveRepository extends JpaRepository<CarReservation, Long>, JpaSpecificationExecutor<CarReservation> {
	
	CarReservation findById(Long id);
	List<CarReservation> findByIdAndName(Long id, String name);

}
