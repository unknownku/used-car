package com.oot.usedcar.service.reserve;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.oot.usedcar.domain.CarReservation;
import com.oot.usedcar.domain.UsedCar;
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

	@Override
	public List<CarReservation> findByIdAndName(Long id, String name) {
		Specification<CarReservation> spec = new Specification<CarReservation>() {

			@Override
			public Predicate toPredicate(Root<CarReservation> root, javax.persistence.criteria.CriteriaQuery<?> query,
					CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<Predicate>();

				if (id !=null && id > 0) {
					predicates.add(cb.and(cb.equal(root.get("id"), id)));
				}
				
				if (name != null && name.length() > 0) {
					predicates.add(cb.and(cb.like(root.get("name"), "%"+name+"%")));
				}
				
				predicates.add(cb.and(cb.notEqual(root.get("paymentFlag"), "1")));
				Predicate[] predicatesArray = new Predicate[predicates.size()];
				
				return cb.and(predicates.toArray(predicatesArray));
			}
		};
		   
	    // using the built in findAll method from Repository with dynamic custom filters 
	    return reserveRepository.findAll(spec);
	}
	
	@Override
	public void deleteById(Long reserveId) {
		// TODO Auto-generated method stub
		reserveRepository.deleteById(reserveId);
	}
}
