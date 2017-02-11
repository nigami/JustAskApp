package com.justask.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.justask.spring.pojo.User;

public class SignInValidator implements Validator	{

	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username", "Username must be entered");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "Password must be entered");
	    
	}

	
}
