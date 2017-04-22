package com.oot.usedcar.service.reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oot.usedcar.domain.CarReservation;
import com.oot.usedcar.repository.CarRepository;
import com.oot.usedcar.repository.ReserveRepository;

@Service
public class ReserveServiceImplement implements ReserveService {

	@Autowired
	private ReserveRepository reserveRepository;


	@Override
	public void save(CarReservation carReserve) {
		// TODO Auto-generated method stub
		reserveRepository.save(carReserve);
	}

	@Override
	public CarReservation findById(Long id) {
		return reserveRepository.findById(id);
	}


}
