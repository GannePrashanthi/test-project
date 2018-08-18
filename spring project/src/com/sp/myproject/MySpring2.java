package com.sp.myproject;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MySpring2 {
//show form data
	@RequestMapping("/formurl")
	public String showdata() {
		return "form";
	}
//process data
	@RequestMapping("/form2url")
	public String processdata() {
		return "form2";
	}
//process 2
	@RequestMapping("/process2url")
	public String Processdata(HttpServletRequest req, Model mod) {
		String s1=req.getParameter("name");
   	 s1=s1.toUpperCase();
   	 
   	 String result= "Hi I am In Uppercase:- " +s1;
   	 
   	 mod.addAttribute("message" , result);
   	 
   	 return "form2";
	}
	
	}

