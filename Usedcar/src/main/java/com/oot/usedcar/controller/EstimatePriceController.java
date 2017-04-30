package com.oot.usedcar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oot.usedcar.form.EstimatePriceForm;
import com.oot.usedcar.service.car.CarService;
import com.oot.usedcar.service.estimate.EstimatePriceService;

@Controller
public class EstimatePriceController {

	@Autowired
	EstimatePriceService estimatePriceService;

	@Autowired
	CarService carService;

	@RequestMapping(value = "/estimatePrice/getModel", method = RequestMethod.POST)
	public String getModel(@Valid EstimatePriceForm estimatePriceForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "estimate";
		}
		String brand = estimatePriceForm.getBrand();
		List<String> modelList = carService.findModel(brand);
		if (modelList != null) {
			model.addAttribute("modelList", modelList);
			return "fragments/estimate :: estimate-model";
		} else {
			return "redirect:/estimatePrice";
		}
	}

	@RequestMapping(value = "/estimatePrice/getSubModel", method = RequestMethod.POST)
	public String getSubModel(@Valid EstimatePriceForm estimatePriceForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "estimate";
		}
		String brand = estimatePriceForm.getBrand();
		String models = estimatePriceForm.getModel();
		List<String> subModelList = carService.findSubModel(brand, models);
		if (subModelList != null) {
			model.addAttribute("subModelList", subModelList);
			return "fragments/estimate :: estimate-submodel";
		} else {
			return "redirect:/estimatePrice";
		}
	}

	@RequestMapping(value = "/estimatePrice/getYear", method = RequestMethod.POST)
	public String getYear(@Valid EstimatePriceForm estimatePriceForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "estimate";
		}
		String brand = estimatePriceForm.getBrand();
		String models = estimatePriceForm.getModel();
		String subModels = estimatePriceForm.getSubModel();
		List<String> yearList = carService.findYear(brand, models, subModels);
		if (yearList != null) {
			model.addAttribute("yearList", yearList);
			return "fragments/estimate :: estimate-year";
		} else {
			return "redirect:/estimatePrice";
		}
	}

	@RequestMapping(value = "/estimatePrice/getCheckList", method = RequestMethod.POST)
	public String getCheckList(@Valid EstimatePriceForm estimatePriceForm, BindingResult bindingResult, Model model) {
		return "fragments/estimate :: estimate-check";
	}

}
