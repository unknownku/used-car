package com.oot.usedcar.controller;

import java.util.List;

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

import com.oot.usedcar.domain.CarReservation;
import com.oot.usedcar.domain.UsedCar;
import com.oot.usedcar.form.ReserveForm;
import com.oot.usedcar.service.InitialDataService;
import com.oot.usedcar.service.reserve.ReserveService;
import com.oot.usedcar.service.usedcar.UsedCarService;
import com.oot.usedcar.util.StringUtil;

@Controller
public class ReserveCarController {

	@Autowired
	ReserveService reserveService;
	
	@Autowired
	UsedCarService usedCarService;
	
	@Autowired
	InitialDataService initialDataService;

	@RequestMapping(value = { "/reserve/{uCarId}" }, method = RequestMethod.GET)
	public String reserve(Model model, @PathVariable("uCarId") String uCarId) {
		
		System.out.println("reserve uCarId id = " + uCarId);
		// car id from search form
		UsedCar uCar = usedCarService.findById(Long.parseLong(uCarId));
		// car.seti
		ReserveForm reserveForm = new ReserveForm();

		reserveForm.setReserveCar(uCar);
		model.addAttribute("payList", initialDataService.getPaymentMethodList());
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

			model.addAttribute("payList", initialDataService.getPaymentMethodList());
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
		carReserve.setCarPrice(reserveForm.getActualSalePrice());
		carReserve.setPaymentFlag("0");

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
}
