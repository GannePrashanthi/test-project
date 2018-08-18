package com.spring.myproject1;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@RequestMapping("showurl1")
	public String show(Model mod) {
	//get customer object
		Customer cust=new Customer();
		//add model attribute
		mod.addAttribute("customer",cust);
	return "customer-form";
	}
	@RequestMapping("processurl1")
	public String process(@Valid@ModelAttribute("customer")Customer cust, BindingResult br) {
		
		if(br.hasErrors()) {
			return "customer-form";
		}
		else {
			return "customer-confirmation";
		}
		
		
			}
}
