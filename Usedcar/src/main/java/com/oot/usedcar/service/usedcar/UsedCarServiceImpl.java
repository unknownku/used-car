package com.oot.usedcar.service.usedcar;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oot.usedcar.domain.UsedCar;
import com.oot.usedcar.repository.UsedCarRepository;

@Service
public class UsedCarServiceImpl implements UsedCarService {

	@Autowired
	private UsedCarRepository usedCardRepository;

	@Override
	public void save(UsedCar usedCar) {
		usedCardRepository.save(usedCar);
	}

	@Override
	public List<UsedCar> findAll() {
		return usedCardRepository.findAll();
	}

	@Override
	public UsedCar findByBrandAndModelAndSubmodelAndYearAndKilometer(String brand, String model, String submodel,
			int year, int kilometer) {
		return usedCardRepository.findByBrandAndModelAndSubmodelAndYearAndKilometer(brand, model, submodel, year,
				kilometer);
	}

	@Override
	public List<UsedCar> findByBrandAndModelAndSubmodelAndYear(String brand, String model, String submodel, int year) {
		// return
		// usedCardRepository.findByBrandAndModelAndSubmodelAndYear(brand,
		// model, submodel, year);
		
		Specification<UsedCar> spec = new Specification<UsedCar>() {

			@Override
			public Predicate toPredicate(Root<UsedCar> root, javax.persistence.criteria.CriteriaQuery<?> query,
					CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<Predicate>();

				if (brand != null && brand.length() > 0) {
					predicates.add(cb.and(cb.like(root.get("brand"), brand+"%")));
				}
				
				if (model != null && model.length() > 0) {
					predicates.add(cb.and(cb.like(root.get("model"), model+"%")));
				}
				
				if (submodel != null && submodel.length() > 0) {
					predicates.add(cb.and(cb.like(root.get("submodel"), "%"+submodel+"%")));
				}
				
				if (year > 0) {
					predicates.add(cb.and(cb.equal(root.get("year"), year)));
				}
				
				predicates.add(cb.and(cb.equal(root.get("status"), "Available")));
				Predicate[] predicatesArray = new Predicate[predicates.size()];
				
				return cb.and(predicates.toArray(predicatesArray));
			}
		};
		   
	    // using the built in findAll method from Repository with dynamic custom filters 
	    return usedCardRepository.findAll(spec);
	}

	@Override
	public UsedCar findById(Long id) {
		return usedCardRepository.findByid(id);
	}

	@Override
	public UsedCar findByCarIdAndProvinceAndStatus(String carId, String province, String status) {
		return usedCardRepository.findByCarIdAndProvinceAndStatus(carId, province, status);
	}


}
