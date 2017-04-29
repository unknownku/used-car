package com.oot.usedcar.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oot.usedcar.domain.Car;
import com.oot.usedcar.domain.CarReservation;
import com.oot.usedcar.domain.UsedCar;
import com.oot.usedcar.form.EstimatePriceForm;
import com.oot.usedcar.form.ReserveForm;
import com.oot.usedcar.form.UsedCarSearchForm;
import com.oot.usedcar.service.InitialDataService;
import com.oot.usedcar.service.car.CarService;
import com.oot.usedcar.service.car.UsedCarService;
import com.oot.usedcar.service.estimate.EstimatePriceService;
import com.oot.usedcar.service.reserve.ReserveService;

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
	InitialDataService initialDataService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index(Model model) {
		System.out.println("index");
		return "index";
	}

	@RequestMapping(value = { "/init" }, method = RequestMethod.GET)
	public String initial(Model model) {
		System.out.println("initial");
		initialDataService.initailUser();
		initialDataService.initailCar();
		initialDataService.initailBuyCar();
		initialDataService.initailUsedCar();

		return "initial";
	}

	@RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
	public String dashboard(Model model) {
		System.out.println("dashboard");
		return "dashboard/index";
	}

	@RequestMapping(value = { "/buycar" }, method = RequestMethod.GET)
	public String buycar(Model model) {
		System.out.println("buycar");
		return "buycar";
	}

	@RequestMapping(value = { "/estimatePrice" }, method = RequestMethod.GET)
	public String estimatePrice(Model model) {
		model.addAttribute("estimatePriceForm", new EstimatePriceForm());
		List<Car> carList = new ArrayList();

		model.addAttribute("carList", initialDataService.getCarList());
		model.addAttribute("price", new BigDecimal("0.00").toString());
		System.out.println("get estimatePrice");
		return "estimate";
	}

	@RequestMapping(value = "/estimatePrice", method = RequestMethod.POST)
	public String estimatePrice(@Valid EstimatePriceForm estimatePriceForm, BindingResult bindingResult, Model model) {
		System.out.println("post estimatePrice");
		if (bindingResult.hasErrors()) {
			System.out.println("estimate error");
			model.addAttribute("carList", initialDataService.getCarList());
			return "estimate";
		}
		// Start mockup data
		// estimatePriceForm.setBrand("TOYOTA");
		// estimatePriceForm.setModel("Altis");
		// estimatePriceForm.setYear(2015);
		// estimatePriceForm.setKilometer(100000);
		// estimatePriceForm.setFlooding(true);
		// estimatePriceForm.setCrashing(true);
		// estimatePriceForm.setUsingType(0);
		// End mockup data

		String brand = estimatePriceForm.getBrand();
		String model2 = estimatePriceForm.getModel();
		int year = estimatePriceForm.getYear();
		int kilometer = estimatePriceForm.getKilometer();
		boolean isFlooding = estimatePriceForm.isFlooding();
		boolean isCrashing = estimatePriceForm.isCrashing();
		int usingType = estimatePriceForm.getUsingType();

		Car car = carService.findByBrandAndModelAndYear(brand, model2, year);
		if (car != null) {
			BigDecimal middlePrice = car.getMiddlePrice();
			BigDecimal depreciationPrice = estimatePriceService.calculateDepreciationPrice(year, kilometer, isFlooding,
					isCrashing, usingType);
			BigDecimal estimatePrice = estimatePriceService.calculateEstimatePrice(middlePrice, depreciationPrice);
			System.out.println(estimatePrice.toString());
			model.addAttribute("carList", initialDataService.getCarList());
			model.addAttribute("price", estimatePrice.toString());
			return "fragments/estimate_frag :: estimate-price";
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
	public String search(@Valid UsedCarSearchForm carSearch, BindingResult result) {
		System.out.println("search");

		String car_brand = carSearch.getBrand();
		String car_model = carSearch.getModel();
		String car_submodel = carSearch.getSubModel();
		int car_year = carSearch.getYear();
		int car_kilometer = carSearch.getKilometer();

		UsedCar used_car = usedCarService.findByBrandAndModelAndSubmodelAndYearAndKilometer(car_brand, car_model,
				car_submodel, car_year, car_kilometer);
		if (used_car != null) {
			System.out.println("Used car is null.");
		} else {
			System.out.println(used_car.getId().toString());
			System.out.println(used_car.getColor());
			System.out.println(used_car.getCarId());
			System.out.println(used_car.getPrice().toString());
			System.out.println(used_car.getYear());
			System.out.println(used_car.getStatus());
			System.out.println(used_car.getReceivingDate());
		}

		if (result.hasErrors())
			System.out.println("hasError");
		return "index";
	}

	@RequestMapping(value = { "/sell" }, method = RequestMethod.GET)
	public String sell(Model model, String t, String t2) {
		System.out.println("sell");
		return "index";
	}

	@RequestMapping(value = { "/reserve/{uCarId}" }, method = RequestMethod.GET)
	public String reserve(Model model, @PathVariable("uCarId") String uCarId) {

		System.out.println("reserve uCarId id = " + uCarId);

		// car id from search form

		UsedCar uCar = usedCarService.findById(Long.parseLong(uCarId));
		
//		car.seti
		ReserveForm reserveForm = new ReserveForm();
//
//		reserveForm.setName("Testname");
//		reserveForm.setAddress("address");
//		reserveForm.setPhoneNumber("000000");
		reserveForm.setReserveCar(uCar);

		model.addAttribute("reserveForm", reserveForm);

		return "reserveForm";

	}

	@RequestMapping(value = { "/saveReserve" }, method = RequestMethod.POST)
	public String saveReserve(@Valid @ModelAttribute("reserveForm") ReserveForm reserveForm, 
							  BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			List<FieldError> xxx = bindingResult.getFieldErrors();
			for (FieldError fieldError : xxx) {
				System.out.println(fieldError.getField());
			}
			model.addAttribute("reserveForm", reserveForm);
//			return "redirect:reserveForm/1";
			return "reserveForm";
		}  
		
		CarReservation carReserve = new CarReservation();
//		carReserve.setId(Long.parseLong("1"));
		carReserve.setName(reserveForm.getName());
		carReserve.setAddress(reserveForm.getAddress());
		carReserve.setPhoneNumber(reserveForm.getPhoneNumber());
		carReserve.setIdCard(reserveForm.getIdCard());
		carReserve.setPayMethod(reserveForm.getPayMethod());
		carReserve.setReservAmount(reserveForm.getReservAmount());
//		carReserve.setReservDate(reserveForm.getReservDate());
		carReserve.setReservNo(reserveForm.getReservNo());
		
		carReserve.setReserveCarId( reserveForm.getReserveCar().getId() + "");
		carReserve.setCarPrice(reserveForm.getReserveCar().getPrice());

		reserveService.save(carReserve);
		System.out.println("saveReserve");
		return "index";
	}
}
