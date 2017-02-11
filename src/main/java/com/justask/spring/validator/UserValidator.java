package com.justask.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.justask.spring.pojo.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class classz) {
		// TODO Auto-generated method stub
		return classz.equals(User.class);
	}

	@Override
	public void validate(Object object, Errors errors) {
		// TODO Auto-generated method stub
	
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstname", "First Name Required");
	     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastname", "Last Name Required");
	     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username", "User Name Required");
	     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "Password Required");
	     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email Required");
	    
	}

		
}
