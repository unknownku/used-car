package com.oot.usedcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oot.usedcar.domain.Province; 

public interface ProvinceRepository extends JpaRepository<Province, Long> {
	  Province findById(Long id); 
	  Province findByNameth(String nameth); 
	  Province findByNameen(String nameen); 
}
