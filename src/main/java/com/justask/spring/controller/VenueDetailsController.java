package com.justask.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.justask.spring.dao.ReviewDAO;
import com.justask.spring.dao.UserDAO;
import com.justask.spring.dao.VenueDAO;
import com.justask.spring.exception.JustAskException;
import com.justask.spring.pojo.Review;
import com.justask.spring.pojo.User;
import com.justask.spring.pojo.Venue;

@Controller
public class VenueDetailsController {
	
	@RequestMapping(value="/venueDetails.htm", method=RequestMethod.GET)
	public ModelAndView venueDetailsHandler(HttpServletRequest request, HttpServletResponse response){
		String venueId =request.getParameter("index");
		System.out.println("venue id......./"+venueId);
		
		HttpSession session= request.getSession();
		String username= (String) session.getAttribute("username");
		
		UserDAO userDAO= new UserDAO();
		try {
			User user=userDAO.get(username);
			request.setAttribute("username", user.getFirstName()+" "+user.getLastName());
		} catch (JustAskException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		VenueDAO venuedao= new VenueDAO();
		Venue venue=venuedao.getSelectedVenue(venueId);
		
		
		ReviewDAO reviewDAO= new ReviewDAO();
		List<Review>reviewlist;
		ModelAndView mv = new ModelAndView();
		try {
			reviewlist=reviewDAO.getVenueSpecificReviews(venueId);
			mv.addObject("reviewList",reviewlist);
			mv.addObject("reviewCount",reviewlist.size());
		} catch (JustAskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(venue!=null){
			mv.addObject("venue",venue);
			mv.addObject("username",username);
		}
		mv.setViewName("venueDetail");
		return mv;
	}
}
