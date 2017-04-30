package com.oot.usedcar.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oot.usedcar.domain.Car;
import com.oot.usedcar.domain.CarReservation;
import com.oot.usedcar.domain.PaymentMethod;
import com.oot.usedcar.domain.Province;
import com.oot.usedcar.domain.UsedCar;
import com.oot.usedcar.form.BuyCarForm;
import com.oot.usedcar.form.EstimatePriceForm;
import com.oot.usedcar.form.ReserveForm;
import com.oot.usedcar.form.UsedCarReserveSearchForm;
import com.oot.usedcar.form.UsedCarSearchForm;
import com.oot.usedcar.service.InitialDataService;
import com.oot.usedcar.service.buycar.BuyCarService;
import com.oot.usedcar.service.car.CarService;
import com.oot.usedcar.service.estimate.EstimatePriceService;
import com.oot.usedcar.service.province.ProvinceService;
import com.oot.usedcar.service.reserve.ReserveService;
import com.oot.usedcar.service.sellcar.SellCarService;
import com.oot.usedcar.service.usedcar.UsedCarService;
import com.oot.usedcar.util.StringUtil;

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
		return "index";
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
		if(kilometer < 0) {
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
		System.out.println("scratchRate "+scratchRate);
		Car car = carService.findByBrandAndModelAndSubModelAndYear(brand, model2, subModel, year);
		if (car != null) {
			BigDecimal middlePrice = car.getMiddlePrice();
			BigDecimal depreciationPrice = estimatePriceService.calculateDepreciationPrice(year, kilometer, isFlooding,
					isCrashing, scratchRate);
			BigDecimal estimatePrice = estimatePriceService.calculateEstimatePrice(middlePrice, depreciationPrice);
			model.addAttribute("price", estimatePrice.toString());
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

	@RequestMapping(value = { "/reserve/{uCarId}" }, method = RequestMethod.GET)
	public String reserve(Model model, @PathVariable("uCarId") String uCarId) {

		System.out.println("reserve uCarId id = " + uCarId);

		// car id from search form

		UsedCar uCar = usedCarService.findById(Long.parseLong(uCarId));

		// car.seti
		ReserveForm reserveForm = new ReserveForm();
		//
		// reserveForm.setName("Testname");
		// reserveForm.setAddress("address");
		// reserveForm.setPhoneNumber("000000");
		reserveForm.setReserveCar(uCar);

		List<PaymentMethod> payList = new ArrayList<>();
		PaymentMethod pay1 = new PaymentMethod();
		pay1.setPayKey("C");
		pay1.setPayValue("Cash");
		payList.add(pay1);
		
		PaymentMethod pay2 = new PaymentMethod();
		pay2.setPayKey("F");
		pay2.setPayValue("Finance");
		payList.add(pay2);
		
		model.addAttribute("payList", payList);
		model.addAttribute("reserveForm", reserveForm);

		return "reserveForm";

	}

	@RequestMapping(value = { "/saveReserve" }, method = RequestMethod.POST)
	public String saveReserve(@Valid @ModelAttribute("reserveForm") ReserveForm reserveForm,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			List<FieldError> xxx = bindingResult.getFieldErrors();
			for (FieldError fieldError : xxx) {
				System.out.println(fieldError.getField());
			}
			model.addAttribute("reserveForm", reserveForm);
			// return "redirect:reserveForm/1";
			return "reserveForm";
		}

		CarReservation carReserve = new CarReservation();
		// carReserve.setId(Long.parseLong("1"));
		carReserve.setName(reserveForm.getName());
		carReserve.setAddress(reserveForm.getAddress());
		carReserve.setPhoneNumber(reserveForm.getPhoneNumber());
		carReserve.setIdCard(reserveForm.getIdCard());
		carReserve.setPayMethod(reserveForm.getPayMethod());
		carReserve.setReservAmount(reserveForm.getReservAmount());
		carReserve.setReservDate(StringUtil.convertStringToDate(reserveForm.getReservDate()));
		carReserve.setReservNo(reserveForm.getReservNo());

		carReserve.setReserveCarId(reserveForm.getReserveCar().getId() + "");
		carReserve.setCarPrice(reserveForm.getReserveCar().getPrice());

		reserveService.save(carReserve);
		
		// Update Used car status to reseved
		UsedCar used_car = usedCarService.findById(reserveForm.getReserveCar().getId());
		used_car.setStatus("Reserved");
		usedCarService.save(used_car);
		
		System.out.println("saveReserve");
		
		model.addAttribute("successHeader", "Reserve Completed !");
		model.addAttribute("successDetail", "Done! You are successfully reserve a car.");
		return "successAction";
	}

	@RequestMapping(value = { "/saveBuycar" }, method = RequestMethod.POST)
	public String saveBuycar(@Valid @ModelAttribute("buyCar") BuyCarForm buyCar, 
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			List<FieldError> xxx = bindingResult.getFieldErrors();
			for (FieldError fieldError : xxx) {
				System.out.println(fieldError.getField());
			}
			model.addAttribute("buyCar", buyCar);
			// return "redirect:reserveForm/1";
			return "buycar";
		}
		
//		BuyCar buyCar = new BuyCar();

		return "index";
	}

	@RequestMapping(value = { "/successAction" }, method = RequestMethod.POST)
	public String successAction(Model model) {
		
//		model.addAttribute("successHeader", "Reserve Completed !");
//		model.addAttribute("successDetail", "Done! You are successfully reserve a car.");
		return "successAction";
	}
}
