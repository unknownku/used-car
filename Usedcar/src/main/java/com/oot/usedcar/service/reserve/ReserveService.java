package com.oot.usedcar.service.reserve;

import com.oot.usedcar.domain.Car;
import com.oot.usedcar.domain.CarReservation;

public interface ReserveService {

	public CarReservation findById(Long id);
	public void save(CarReservation carReserve);

}
