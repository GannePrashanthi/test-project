package com.spring.myproject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/new")
public class Servletspring {
 @RequestMapping("/")
public String wish() {
	return "wish";
}
 @RequestMapping("/formurl1")
 public String form() {
	 return "formpage";
 }
 @RequestMapping("/process2")
 public String form1(HttpServletRequest req, Model mod ) {
	 //getting values from form page
	 String s1=req.getParameter("name");
	 //convert it into uppercase
	 s1=s1.toUpperCase();
	 //add message
	 String result="hi iam in uppercase"+s1;
	 //add attributes
	 mod.addAttribute("message", result);
	 return "formpage1";
	 
 }
 @RequestMapping("/process3")
 public String form1(@RequestParam("name") String s1, Model mod ) {
	 
	 //convert it into uppercase
	 s1=s1.toUpperCase();
	 //add message
	 String result="hi iam in uppercase"+s1;
	 //add attributes
	 mod.addAttribute("message", result);
	 return "formpage1";
 }
}
