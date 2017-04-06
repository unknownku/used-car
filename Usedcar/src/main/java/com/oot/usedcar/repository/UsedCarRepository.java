package com.oot.usedcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oot.usedcar.domain.UsedCar;

public interface UsedCarRepository extends JpaRepository<UsedCar, Long> {

}
