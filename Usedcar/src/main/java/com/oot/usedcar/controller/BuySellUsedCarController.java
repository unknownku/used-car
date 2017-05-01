package com.oot.usedcar.controller;

import java.math.BigDecimal;import java.util.ArrayList;import java.util.List;import javax.validation.Valid;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.security.core.Authentication;import org.springframework.security.core.context.SecurityContextHolder;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.validation.BindingResult;import org.springframework.validation.FieldError;import org.springframework.validation.ObjectError;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import com.oot.usedcar.domain.BuyCar;import com.oot.usedcar.domain.Car;import com.oot.usedcar.domain.CarReservation;import com.oot.usedcar.domain.Province;import com.oot.usedcar.domain.SellCar;import com.oot.usedcar.domain.UsedCar;import com.oot.usedcar.form.BuyCarForm;import com.oot.usedcar.form.EstimatePriceForm;import com.oot.usedcar.form.ReserveForm;import com.oot.usedcar.form.UsedCarReserveSearchForm;import com.oot.usedcar.form.UsedCarSearchForm;import com.oot.usedcar.service.InitialDataService;import com.oot.usedcar.service.buycar.BuyCarService;import com.oot.usedcar.service.car.CarService;import com.oot.usedcar.service.estimate.EstimatePriceService;import com.oot.usedcar.service.province.ProvinceService;import com.oot.usedcar.service.reserve.ReserveService;import com.oot.usedcar.service.sellcar.SellCarService;import com.oot.usedcar.service.usedcar.UsedCarService;import com.oot.usedcar.util.StringUtil;

@Controller
public class BuySellUsedCarController {

	@Autowired
	EstimatePriceService estimatePriceService;

	@Autowired
	CarService carService;

	@Autowired
	UsedCarService usedCarService;

	@Autowired
	ReserveService reserveService;

	@Autowired
	BuyCarService buyCarService;

	@Autowired
	ProvinceService provinceService;

	@Autowired
	InitialDataService initialDataService;

	@Autowired
	SellCarService sellCarService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index(Model model) {
		System.out.println("index");
		return "redirect:/login";
	}

	@RequestMapping(value = { "/init" }, method = RequestMethod.GET)
	public String initial(Model model) {
		System.out.println("initial");
		initialDataService.initailUser();
		initialDataService.initailCar();
		initialDataService.initailBuyCar();
		initialDataService.initailUsedCar();
		initialDataService.initailProvince();
		return "initial";
	}

	@RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
	public String dashboard(Model model) {
		System.out.println("dashboard");
		return "dashboard/index";
	}



	@RequestMapping(value = { "/estimatePrice" }, method = RequestMethod.GET)
	public String estimatePrice(Model model) {
		model.addAttribute("estimatePriceForm", new EstimatePriceForm());
		List<String> brandList = carService.findBrand();
		model.addAttribute("brandList", brandList);
		model.addAttribute("price", new BigDecimal("0.00").toString());
		System.out.println("get estimatePrice");
		return "estimate";
	}

	@RequestMapping(value = "/estimatePrice", method = RequestMethod.POST)
	public String estimatePrice(@Valid EstimatePriceForm estimatePriceForm, BindingResult bindingResult, Model model) {
		System.out.println("post estimatePrice");
		int kilometer = estimatePriceForm.getKilometer();

		if (kilometer < 0) {
			ObjectError objError = new ObjectError("kilometer", "กรุณากรอกระยะทางที่ใช้ไปให้มากกว่าหรือเท่ากับศูนย์");
			bindingResult.addError(objError);
		}

		if (bindingResult.hasErrors()) {
			model.addAttribute("price", 0);
			return "fragments/estimate :: estimate-price";

		}
		String brand = estimatePriceForm.getBrand();
		String model2 = estimatePriceForm.getModel();
		String subModel = estimatePriceForm.getSubModel();
		int year = estimatePriceForm.getYear();
		boolean isFlooding = estimatePriceForm.isFlooding();
		boolean isCrashing = estimatePriceForm.isCrashing();
		int scratchRate = estimatePriceForm.getScratchRate();
		System.out.println("scratchRate " + scratchRate);
		Car car = carService.findByBrandAndModelAndSubModelAndYear(brand, model2, subModel, year);
		if (car != null) {
			BigDecimal middlePrice = car.getMiddlePrice();
			BigDecimal depreciationPrice = estimatePriceService.calculateDepreciationPrice(kilometer, isFlooding,
					isCrashing, scratchRate);
			BigDecimal estimatePrice = estimatePriceService.calculateEstimatePrice(middlePrice, depreciationPrice);			if(estimatePrice.compareTo(BigDecimal.ZERO) == -1){				model.addAttribute("price", "Your price is negative.");			} else {
				model.addAttribute("price", estimatePrice.toString());			}
			return "fragments/estimate :: estimate-price";
		} else {
			return "redirect:/estimatePrice";
		}
	}

	@RequestMapping(value = { "/buy" }, method = RequestMethod.GET)
	public String buy(Model model, String t) {
		System.out.println("buy");
		return "index";
	}

	@RequestMapping(value = { "/carSearch" }, method = RequestMethod.GET)
	public String carSearch(Model model, String t) {
		model.addAttribute("carSearch", new UsedCarSearchForm());
		System.out.println("get car search");
		return "usedcarsearchform";
	}

	@RequestMapping(value = { "/carSearch" }, method = RequestMethod.POST)
	public String search(@Valid UsedCarSearchForm carSearch, BindingResult result, Model model) {
		System.out.println("search");

		String car_brand = carSearch.getBrand();
		String car_model = carSearch.getModel();
		String car_submodel = carSearch.getSubModel();
		int car_year = carSearch.getYear();

		List<UsedCar> used_car = usedCarService.findByBrandAndModelAndSubmodelAndYear(car_brand, car_model,
				car_submodel, car_year);
		if (used_car == null) {
			System.out.println("Used car is null.");
		} else {
			model.addAttribute("usedCarList", used_car);
			// System.out.println(used_car.get(0).getId());
			// System.out.println(used_car.getColor());
			// System.out.println(used_car.getCarId());
			// System.out.println(used_car.getPrice());
			// System.out.println(used_car.getYear());
			// System.out.println(used_car.getStatus());
			// System.out.println(used_car.getReceivingDate());
			model.addAttribute("carSearch", new UsedCarSearchForm());
		}

		if (result.hasErrors())
			System.out.println("hasError");
		return "usedcarsearchform";
	}

	@RequestMapping(value = { "/sell" }, method = RequestMethod.GET)
	public String sell(Model model, String t, String t2) {
		model.addAttribute("carReserveSearch", new UsedCarReserveSearchForm());
		System.out.println("sell car");
		return "sellcar";
	}

	@RequestMapping(value = { "/sell" }, method = RequestMethod.POST)
	public String reserveSearch(@Valid UsedCarReserveSearchForm carReserveSearch, BindingResult result, Model model) {
		System.out.println("search");

		Long reserve_id = carReserveSearch.getReserveId();
		String reserve_name = carReserveSearch.getName();

		List<CarReservation> reserve_car = reserveService.findByIdAndName(reserve_id, reserve_name);
		if (reserve_car == null) {
			System.out.println("Reserved car is null.");
		} else {
			model.addAttribute("reservedCarList", reserve_car);
			model.addAttribute("carReserveSearch", new UsedCarReserveSearchForm());
		}

		if (result.hasErrors())
			System.out.println("hasError");
		return "sellcar";
	}

	@RequestMapping(value = { "/sell/{uReserveId}" }, method = RequestMethod.GET)
	public String sellCar(@PathVariable("uReserveId") String uReserveId, Model model) {

		Long reserveId = Long.parseLong(uReserveId);
		System.out.println("reserve id = " + uReserveId);

		CarReservation uReservation = reserveService.findById(reserveId);

		if (uReservation != null) {
			uReservation.setPaymentFlag("1");
			reserveService.save(uReservation);

			UsedCar used_car = usedCarService.findById(Long.parseLong(uReservation.getReserveCarId()));
			SellCar sellcar = new SellCar();
			sellcar.setReservationId(reserveId);
			sellcar.setAmount(
					Double.parseDouble(uReservation.getCarPrice().subtract(uReservation.getReservAmount()).toString()));

			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName(); // get logged in username
			sellcar.setSaleBy(name);

			sellCarService.save(sellcar);

			used_car.setStatus("Sold");
			usedCarService.save(used_car);
			System.out.println("savesell");

			model.addAttribute("successHeader", "Sold Completed !");
			model.addAttribute("successDetail", "Done! You are successfully sold a car.");
			return "successAction";
		}
		model.addAttribute("carReserveSearch", new UsedCarReserveSearchForm());
		return "sellcar";
	}

	@RequestMapping(value = { "/buycar" }, method = RequestMethod.GET)
	public String buycar(Model model) {
		model.addAttribute("buyCar", new BuyCarForm());
		// List<BuyCar> nameList = buyCarService.findAll();
		// model.addAttribute("nameList", nameList);

		List<Province> provinceList = provinceService.findAll();
		model.addAttribute("provinceList", provinceList);

		List<Car> carList = new ArrayList();
		model.addAttribute("carList", initialDataService.getCarList());

		System.out.println("buycar");
		return "buycar";
	}
	
	@RequestMapping(value = { "/saveBuycar" }, method = RequestMethod.POST)
	public String saveBuycar(@Valid @ModelAttribute("buyCar") BuyCarForm buyCar, 
			BindingResult bindingResult, Model model) {
		
		List<Province> provinceList = provinceService.findAll();
		model.addAttribute("provinceList", provinceList);
		model.addAttribute("carList", initialDataService.getCarList());
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("buyCar", buyCar);
			// return "redirect:reserveForm/1";
			return "buycar";
		}
		
		String licenseplate = buyCar.getLicenseplate();
		String licenseprovince = buyCar.getLicenseprovince();
		UsedCar usedCar = usedCarService.findByCarIdAndProvinceAndStatus(licenseplate, licenseprovince, "Available");		if (usedCar != null) {			
		    FieldError objError = new FieldError("licenseplate","licenseplate", "Used car was duplicated.");		    bindingResult.addError(objError);		    
			model.addAttribute("buyCar", buyCar);
			return "buycar";	
		} 

		BuyCar buyCarSave = new BuyCar();
		buyCarSave.setGender(buyCar.getGender());
		buyCarSave.setCusid(buyCar.getCusid());
		buyCarSave.setName(buyCar.getName());
		buyCarSave.setLastname(buyCar.getLastname());
		buyCarSave.setAddress(buyCar.getAddress());
		buyCarSave.setPhone(buyCar.getPhone());
		// buyCarSave.setBuydate(new Date());

		buyCarSave.setLicensedate(StringUtil.convertStringToDate(buyCar.getLicensedate()));
		buyCarSave.setLicenseNo(buyCar.getLicenseNo());
		buyCarSave.setCartype(buyCar.getCartype());
		buyCarSave.setCarstyle(buyCar.getCarstyle());
		buyCarSave.setCarbrand(buyCar.getCarbrand());
		buyCarSave.setCarmodel(buyCar.getCarmodel());
		buyCarSave.setCarmodelsub(buyCar.getCarmodelsub());
		buyCarSave.setCaryear(buyCar.getCaryear());
		buyCarSave.setCarcolor(buyCar.getCarcolor());
		buyCarSave.setCarno(buyCar.getCarno());
		buyCarSave.setCarnoat(buyCar.getCarnoat());
		buyCarSave.setCarenginebrand(buyCar.getCarenginebrand());
		buyCarSave.setCarengineno(buyCar.getCarengineno());
		buyCarSave.setCarenginenoat(buyCar.getCarenginenoat());
		buyCarSave.setFueltype(buyCar.getFueltype());
		buyCarSave.setGascylinno(buyCar.getGascylinno());
		buyCarSave.setPistonno(buyCar.getPistonno());
		buyCarSave.setCarcc(buyCar.getCarcc());
		buyCarSave.setCarhotpower(buyCar.getCarhotpower());
		buyCarSave.setCaretc(buyCar.getCaretc());
		buyCarSave.setCarweight(buyCar.getCarweight());
		buyCarSave.setCarseats(buyCar.getCarseats());
		buyCarSave.setLicenseplate(buyCar.getLicenseplate());
		buyCarSave.setLicenseprovince(buyCar.getLicenseprovince());
		buyCarSave.setPrice(buyCar.getPrice());
		buyCarSave.setKilometer(buyCar.getKilometer());
		buyCarService.save(buyCarSave);

		UsedCar usedcar = new UsedCar();
		usedcar.setBrand(buyCar.getCarbrand());
		usedcar.setCarId(buyCar.getLicenseplate());
		usedcar.setProvince(buyCar.getLicenseprovince());
		usedcar.setColor(buyCar.getCarcolor());
		usedcar.setKilometer(buyCar.getKilometer());
		usedcar.setModel(buyCar.getCarmodel());
		usedcar.setPrice(buyCar.getPrice());
		usedcar.setSubmodel(buyCar.getCarmodelsub());
		usedcar.setYear(buyCar.getCaryear());
		usedcar.setStatus(buyCar.getStatus());
		usedCarService.save(usedcar);

		model.addAttribute("successHeader", "Save Completed !");
		model.addAttribute("successDetail", "Done! You are successfully add new used car.");
		return "successAction";
	}

	@RequestMapping(value = { "/successAction" }, method = RequestMethod.POST)
	public String successAction(Model model) {

		// model.addAttribute("successHeader", "Reserve Completed !");
		// model.addAttribute("successDetail", "Done! You are successfully
		// reserve a car.");
		return "successAction";
	}

	@RequestMapping(value = { "/removeReserve" }, method = RequestMethod.POST)
	public String removeReserve(@ModelAttribute("usedCarReserveSearchForm") UsedCarReserveSearchForm carReserveSearch,
			Model model) {

		Long id = carReserveSearch.getReserveId();
		System.out.println(id);
		reserveService.deleteById(id);

		model.addAttribute("successHeader", "Delete Reserve Completed !");
		model.addAttribute("successDetail", "Done! You are already delete reservation.");
		return "successAction";
	}
}
