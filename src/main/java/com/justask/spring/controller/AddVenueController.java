package com.justask.spring.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.justask.spring.dao.UserDAO;
import com.justask.spring.dao.VenueDAO;
import com.justask.spring.exception.JustAskException;
import com.justask.spring.pojo.Address;
import com.justask.spring.pojo.Review;
import com.justask.spring.pojo.User;
import com.justask.spring.pojo.Venue;
import com.justask.spring.utils.CommonUtilsConstant;

@Controller
public class AddVenueController {
/*	@Autowired
	@Qualifier("signValidator")
	SignInValidator signValidator;*/
	
	
	@RequestMapping(value="/addNewVenue.htm",method=RequestMethod.POST)
	public ModelAndView addVenueUserHandler(HttpServletRequest request){
		System.out.println("inside newVenueController"+request.getParameter("venueDesc")+"......."+request.getParameter("venueName"));
		ModelAndView mv= new ModelAndView();
		
		Address venueAdd= new Address();
		venueAdd.setAddrLine1(request.getParameter("venueAddress.addrLine1"));
		venueAdd.setAddrLine2(request.getParameter("venueAddress.addrLine2"));
		venueAdd.setCity(request.getParameter("venueAddress.city"));
		venueAdd.setState(request.getParameter("venueAddress.state"));
		venueAdd.setCountry(request.getParameter("venueAddress.country"));
		venueAdd.setAddrCategory(request.getParameter("venueType"));
		venueAdd.setZipcode(Integer.valueOf(request.getParameter("venueAddress.zipcode")));
		
		Venue venue = new Venue();
		venue.setVenueAddress(venueAdd);
		venue.setVenueDesc(request.getParameter("venueDesc"));
		venue.setVenueName(request.getParameter("venueName"));
		venue.setVenueRange(request.getParameter("venueRange"));
		venue.setVenueType(request.getParameter("venueType"));
		venue.setVenueImgLocation("b1.jpg");
		venue.setVenueCreateDate(new Date());
		
		VenueDAO venueDao= new VenueDAO();
		String result=venueDao.addNewVenue(venue);
		if(result.equalsIgnoreCase("success")){
			mv.addObject("venueAddStatus", "New Venue added successfully!");
		}else{
			mv.addObject("venueAddStatus", "Sorry! Venue not added, try again!");
		}
		
		
		HttpSession session= request.getSession();
		String username= (String) session.getAttribute("username");
		UserDAO userDao= new UserDAO();
		User user;

		List<Venue>venueList= new ArrayList<Venue>();
		List<Review> reviewList=  new ArrayList<Review>();
		try {
			user = userDao.getUser(username);
			venueList= venueDao.getVenue(user);
			reviewList= venueDao.getReviews(user);
		
		
		
		for(Review review: reviewList){
			System.out.println("reviewList...."+review.getDescription()+" "+review.getReviewId());
		}
		mv.addObject("venueList",venueList);
		mv.addObject("reviewList", reviewList);
		
		
		} catch (JustAskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName(CommonUtilsConstant.DASHBOARD_USER);
		return mv;
		
	}
}
