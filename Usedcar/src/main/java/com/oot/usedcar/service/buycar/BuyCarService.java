package com.oot.usedcar.service.buycar;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oot.usedcar.domain.BuyCar;

public interface BuyCarService {

	public BuyCar findByLicenseplate(String licenseplate);
	public BuyCar findByLicenseprovince(String licenseprovince);
	
	public BuyCar findByLicenseplateAndLicenseprovince(String licenseplate, String licenseprovince);
	
	public List<BuyCar> findAll();
	public void save(BuyCar BuyCar);

	
}
