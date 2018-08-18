package com.spring.myproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Controllertest {
	 @RequestMapping("/")
	 public String wish() {
	 	return "wish";
	 }
	@RequestMapping("/formurl1")
	public String showformdata() {
return "formpage";
}
	
}