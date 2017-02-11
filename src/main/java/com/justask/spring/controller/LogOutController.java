package com.justask.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.api.client.json.Json;
import com.justask.spring.dao.UserDAO;
import com.justask.spring.dao.VenueDAO;
import com.justask.spring.pojo.Review;
import com.justask.spring.pojo.Venue;
import com.justask.spring.utils.CalculateIPAddressUtil;
import com.justask.spring.utils.CommonUtilsConstant;

@Controller
public class LogOutController {

	@RequestMapping(value="/logout.htm",method = RequestMethod.GET)
	public String handleSignInRequest(HttpServletRequest request, HttpServletResponse response ) throws Exception	{
	
		System.out.println("......signup");
	
			
			HttpSession session= request.getSession();
			if(session!=null){
				session.invalidate();
				JSONObject json = new JSONObject();
				json.put("home", CommonUtilsConstant.HOMEPAGE+".jsp");
			}
		return null;			
	}		
	
}
