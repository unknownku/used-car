package com.oot.usedcar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BuySellUsedCarController {
	

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model) {
		System.out.println("index");
        return "index";
    }
	
	@RequestMapping(value = {"/evaluate"}, method = RequestMethod.GET)
    public String evaluate(Model model, String t) {
		System.out.println("evaluate");
        return "index";
    }
	
	@RequestMapping(value = {"/buy"}, method = RequestMethod.GET)
    public String buy(Model model, String t) {
		System.out.println("buy");
        return "index";
    }
	
	@RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public String search(Model model, String t, String t2) {
		System.out.println("search");
		return "index";
    }

	@RequestMapping(value = {"/reserve"}, method = RequestMethod.GET)
    public String reserve(Model model, String t, String t2) {
		System.out.println("reserve");
		return "index";
    }
	
	@RequestMapping(value = {"/sell"}, method = RequestMethod.GET)
    public String sell(Model model, String t, String t2) {
		System.out.println("sell");
		return "index";
    }
	
	
}
