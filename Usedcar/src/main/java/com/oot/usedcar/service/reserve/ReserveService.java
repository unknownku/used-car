package com.oot.usedcar.service.reserve;

import java.util.List;
import com.oot.usedcar.domain.CarReservation;

public interface ReserveService {

	public CarReservation findById(Long id);
	public void save(CarReservation carReserve);
	public void deleteById(Long id);
	public List<CarReservation> findByIdAndName(Long id, String name);

}
