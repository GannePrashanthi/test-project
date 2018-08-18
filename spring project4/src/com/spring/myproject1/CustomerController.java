package com.spring.myproject1;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {   

@InitBinder
public void initBinder(WebDataBinder databinder) {
	StringTrimmerEditor stringtrimmereditor=new StringTrimmerEditor(true);
	databinder.registerCustomEditor(String.class,stringtrimmereditor);
}
	
	@RequestMapping("/showurl")
	public String show(Model mod) {
		mod.addAttribute("customer",new Customer());
		return "customer";
	}
@RequestMapping("/processurlc")
public String process(@Valid@ModelAttribute("customer")Customer cust,BindingResult br) {
	
	if(br.hasErrors()) {
		return "customer";
	}
	else {
	return"customer-confirmation";
}
}
}
