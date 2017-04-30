package com.oot.usedcar.service.province;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oot.usedcar.domain.Province;
import com.oot.usedcar.repository.ProvinceRepository;

@Service
public class ProvinceServiceImplement implements ProvinceService {

	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Override
	public List<Province> findAll() {
		// TODO Auto-generated method stub
		return provinceRepository.findAll();
	}

}
