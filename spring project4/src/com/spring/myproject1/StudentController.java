package com.spring.myproject1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class StudentController {
	
@RequestMapping("/")
	public String home() {
		return "home";
	}
	@RequestMapping("/showformpageurl")
	public String showform(Model mod) {
		//create student class object
		Student s=new Student();
		//add student attribute
		mod.addAttribute("student",s);
	    return "student-form";
	}
	@RequestMapping("/processurl")
	public String processform(@ModelAttribute("student") Student s) {
		   System.out.println("firstname::"+s.getFirstname());
		   System.out.println("lastname::"+s.getLastname());
		   System.out.println("country::"+s.getCountry());
		return "confirmation";
	}

}
