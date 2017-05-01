package com.oot.usedcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.oot.usedcar.domain.CarReservation;

public interface ReserveRepository
		extends JpaRepository<CarReservation, Long>, JpaSpecificationExecutor<CarReservation> {

	CarReservation findById(Long id);
	List<CarReservation> findByIdAndName(Long id, String name);

	@Modifying
	@Transactional
	@Query("delete from CarReservation c where c.id = ?1")
	void deleteById(Long id);

}
