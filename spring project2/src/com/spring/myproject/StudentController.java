package com.spring.myproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
   @RequestMapping("/formurl1")
   public String form(Model mod) {
	   //create student object
	   Student s=new Student();
	   //add model attribute
	   mod.addAttribute("student",s);
		 return "student-formpage";
	 }
   @RequestMapping("process3")
	public String processfrom(@ModelAttribute("student") Student s) {
	   System.out.println("firstname::"+s.getFirstname());
	   System.out.println("lastname::"+s.getLastname());
	   System.out.println("country::"+s.getCountry());
	   return "student-confirmation";
}

}
