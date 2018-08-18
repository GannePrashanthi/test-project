package com.spring.myprojectannotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeContraintValidator 
                  implements ConstraintValidator<CourseCode,String>{
	private String coursePrefix;
	@Override
	public void initialize(CourseCode cc) {
		coursePrefix=cc.value();
	}
	@Override
	public boolean isValid(String thecode,ConstraintValidatorContext cvc) {
		Boolean result=thecode.startsWith(coursePrefix);
		
		return result;
	}

}
