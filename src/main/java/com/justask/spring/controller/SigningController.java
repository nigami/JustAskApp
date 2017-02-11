package com.justask.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.justask.spring.dao.UserDAO;
import com.justask.spring.dao.VenueDAO;
import com.justask.spring.pojo.Review;
import com.justask.spring.pojo.User;
import com.justask.spring.pojo.Venue;
import com.justask.spring.utils.CommonUtilsConstant;
import com.justask.spring.validator.SignInValidator;
import com.justask.spring.validator.UserValidator;

@Controller
public class SigningController {
	
	
	@RequestMapping(value="/dashboard.htm",method = RequestMethod.GET)
	public ModelAndView getSignInHandler(@ModelAttribute("user") User user,HttpServletRequest request, HttpServletResponse response ) throws Exception	{
		ModelAndView mv= new ModelAndView();
		System.out.println("dashboard");
		try{
			if(request.getSession(false)!=null){
				UserDAO userDao= new UserDAO();
				String username= (String) request.getSession().getAttribute("username");
				
				
				user=userDao.get(username);
				
				
				if(!username.isEmpty() && !user.isBlacklist()){
		
					mv.addObject("username", user.getFirstName()+" "+user.getLastName());
					
					List<Venue>venueList= new ArrayList<Venue>();
					VenueDAO venueDao= new VenueDAO();
					
					venueList= venueDao.getVenue(user);
					//venueList= venueDao.get5Venue(user);
					
					//venueList= venueDao.getVenuePagination(user,0);
					/*for(Venue venue: venueList){
						System.out.println("venueList...."+venue.getVenueName()+" "+venue.getVenueAddress().getCity());
					}*/
					List<Review> reviewList=  new ArrayList<Review>();
					reviewList= venueDao.getReviews(user);
					/*for(Review review: reviewList){
						System.out.println("reviewList...."+review.getDescription()+" "+review.getReviewId());
					}*/
					
					List<Venue>allVenueList= new  ArrayList<Venue>();
					allVenueList=venueDao.getAllVenues();
					
					HttpSession session= request.getSession();
					session.setAttribute("allVenueList",allVenueList);
					
					mv.addObject("venueList",venueList);
					mv.addObject("reviewList", reviewList);
					
					if(CommonUtilsConstant.USERTYPE_ADMIN.equalsIgnoreCase(user.getUserType())){
							mv.setViewName(CommonUtilsConstant.DASHBOARD_ADMIN);
							mv.addObject("userType", CommonUtilsConstant.USERTYPE_ADMIN);
							return mv;
						}
						mv.setViewName(CommonUtilsConstant.DASHBOARD_USER);
						if(CommonUtilsConstant.USERTYPE_OWNER.equalsIgnoreCase(user.getUserType())){
							mv.addObject("userType", CommonUtilsConstant.USERTYPE_OWNER);
						}else if(CommonUtilsConstant.USERTYPE_USER.equalsIgnoreCase(user.getUserType())){
							mv.addObject("userType",  CommonUtilsConstant.USERTYPE_USER);
							
						}
				}else{
					
					mv.addObject("signInError", "Wrong Username/Password");
					mv.setViewName(CommonUtilsConstant.HOMEPAGE);
				}
			}else{
				
				mv.addObject("ErrMsg","Session TimeOut!!");
				mv.setViewName("error");
			}
			
		}catch(Exception e){
			System.out.println("Inside dashboard home");
			mv.setViewName(CommonUtilsConstant.HOMEPAGE);
			System.out.println("Exception: " + e.getMessage());	
			e.printStackTrace();
		}	
		
		return mv;
	}
	
	@Autowired
	@Qualifier("signValidator")
	SignInValidator signValidator;

	@RequestMapping(value="/signIn.htm",method = RequestMethod.POST)
	public ModelAndView handleSignInRequest(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request,HttpServletResponse response ) throws Exception	{
		signValidator.validate(user, result);
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName(CommonUtilsConstant.HOMEPAGE);
		}
	
		try{
			
			String rememberMe= request.getParameter("rememberMeId");
			System.out.println("rememberMeId"+rememberMe);
			
			if(rememberMe!=null && "True".equalsIgnoreCase(rememberMe)){
				Cookie cookie1= new Cookie("usernameCookie",user.getUsername());
				Cookie cookie2= new Cookie("passwordCookie",user.getPassword());
				
				cookie1.setMaxAge(24*60*60);
				cookie2.setMaxAge(24*60*60);
				
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}
			
			UserDAO userDao= new UserDAO();
			user=userDao.authenticateUser(user);
			//System.out.println("!user.isBlacklist()........."+!user.isBlacklist());
			if(null!=user && !user.isBlacklist()){
				
					HttpSession session= request.getSession();
					session.setAttribute("username",user.getUsername());
				
				mv.addObject("username", user.getFirstName()+" "+user.getLastName());
				
				List<Venue>venueList= new ArrayList<Venue>();
				VenueDAO venueDao= new VenueDAO();
				
				venueList= venueDao.getVenue(user);
				//venueList= venueDao.get5Venue(user);
				
				for(Venue venue: venueList){
					System.out.println("venueList...."+venue.getVenueName()+" "+venue.getVenueAddress().getCity());
				}
				List<Review> reviewList=  new ArrayList<Review>();
				reviewList= venueDao.getReviews(user);
				for(Review review: reviewList){
					System.out.println("reviewList...."+review.getDescription()+" "+review.getReviewId());
				}
				mv.addObject("venueList",venueList);
				mv.addObject("reviewList", reviewList);
				/*String ipAddress= CalculateIPAddressUtil.getClientIpAddress(request);
				System.out.println("my ip................."+request.getRemoteAddr());
				*/
				System.out.println("user.getUserType"+user.getUserType());
					if(CommonUtilsConstant.USERTYPE_ADMIN.equalsIgnoreCase(user.getUserType())){
						mv.setViewName(CommonUtilsConstant.DASHBOARD_ADMIN);
						mv.addObject("userType", CommonUtilsConstant.USERTYPE_ADMIN);
						return mv;
					}
					mv.setViewName(CommonUtilsConstant.DASHBOARD_USER);
					if(CommonUtilsConstant.USERTYPE_OWNER.equalsIgnoreCase(user.getUserType())){
						mv.addObject("userType", CommonUtilsConstant.USERTYPE_OWNER);
					}else if(CommonUtilsConstant.USERTYPE_USER.equalsIgnoreCase(user.getUserType())){
						mv.addObject("userType",  CommonUtilsConstant.USERTYPE_USER);
						
					}
			}else{
				if(user!=null && user.isBlacklist()){
					mv.addObject("signInError", "You have been blacklisted");
				}else{
					mv.addObject("signInError", "Wrong Username/Password");
				}
				
				mv.setViewName(CommonUtilsConstant.HOMEPAGE);
			}
		}catch(Exception e){
			mv.addObject("signInError", "Wrong Username/Password");
			mv.setViewName(CommonUtilsConstant.HOMEPAGE);
			System.out.println("Exception: " + e.getMessage());	
			e.printStackTrace();
		}
		
		return mv;
	}
	
	/*
	 * SignUp of User/Owner/Admin
	*/
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	@RequestMapping(value="/signUp.htm",method = RequestMethod.POST)
	public ModelAndView handleSignUpRequest(@Valid @ModelAttribute("user") User user, BindingResult result, HttpServletRequest request) throws Exception	{
		validator.validate(user, result);
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName(CommonUtilsConstant.HOMEPAGE);
			return mv;
		}
		
		System.out.println("......signup");
		try{
			
			UserDAO userDao= new UserDAO();
			user=userDao.get(user.getUsername());
			//System.out.println("!user.isBlacklist()........."+!user.isBlacklist());
			if(null==user ){
			userDao.createUser(user);
			}
			if(user==null){
				mv.setViewName(CommonUtilsConstant.HOMEPAGE);
				mv.addObject("error", "Username already exist!");
				return mv;
			}
		HttpSession session= request.getSession();
		session.setAttribute("username",user.getUsername());
		session.setAttribute("user", user);
		
		if(user.getUserType().equalsIgnoreCase(CommonUtilsConstant.USERTYPE_ADMIN)){
			mv.setViewName(CommonUtilsConstant.DASHBOARD_ADMIN);
			mv.addObject("userType", CommonUtilsConstant.USERTYPE_ADMIN);
			mv.addObject("username", user.getFirstName()+" "+user.getLastName());
			return mv;
		}
		mv.setViewName(CommonUtilsConstant.DASHBOARD_USER);
		if(user.getUserType().equalsIgnoreCase(CommonUtilsConstant.USERTYPE_OWNER)){
			mv.addObject("userType", CommonUtilsConstant.USERTYPE_OWNER);
		}else if(user.getUserType().equalsIgnoreCase(CommonUtilsConstant.USERTYPE_USER)){
			mv.addObject("userType",  CommonUtilsConstant.USERTYPE_USER);
			mv.addObject("username", user.getFirstName()+" "+user.getLastName());
		}
		
		}catch(Exception e){
			mv.setViewName(CommonUtilsConstant.HOMEPAGE);
			System.out.println("Exception: " + e.getMessage());	
		}
		return mv;
		
	}
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		System.out.println("ilaaa");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName(CommonUtilsConstant.DASHBOARD_ADMIN);
		return model;

	}
	
}
