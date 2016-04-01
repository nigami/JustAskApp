package com.justask.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/signIn.htm")
public class SignInController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView handleSignInRequest(HttpServletRequest req, HttpServletResponse res) throws Exception	{
		ModelAndView mv= new ModelAndView("success");
		return  mv;
	}
	
}
