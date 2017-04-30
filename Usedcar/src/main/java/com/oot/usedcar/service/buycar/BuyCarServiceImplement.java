package com.oot.usedcar.service.buycar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oot.usedcar.domain.BuyCar;
import com.oot.usedcar.repository.BuyCarRepository;

@Service
public class BuyCarServiceImplement implements BuyCarService {

	@Autowired
	private BuyCarRepository buyCarRepository;

	@Override
	public List<BuyCar> findAll() {
		return buyCarRepository.findAll();
	}
	
	@Override
	public void save(BuyCar buyCar) {
		buyCarRepository.save(buyCar);
	}

	@Override
	public BuyCar findByLicenseplate(String licenseplate) {
		return buyCarRepository.findByLicenseplate(licenseplate);
	}

	@Override
	public BuyCar findByLicenseprovince(String licenseprovince) {
		return buyCarRepository.findByLicenseprovince(licenseprovince);
	}

	@Override
	public BuyCar findByLicenseplateAndLicenseprovince(String licenseplate, String licenseprovince) {
		return buyCarRepository.findByLicenseplateAndLicenseprovince(licenseplate, licenseprovince);
	}



}
