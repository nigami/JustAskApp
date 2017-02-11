package com.justask.spring.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.justask.spring.dao.UserDAO;
import com.justask.spring.exception.JustAskException;
import com.justask.spring.pojo.User;
import com.justask.spring.pojo.Venue;

@Controller
public class PreciousVenueController {

	@RequestMapping(value="/preciousVenue.htm", method=RequestMethod.GET)
	public ModelAndView favAndVisitedVenueHandler(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mv= new ModelAndView();
		HttpSession session= request.getSession(false);
		String username=(String)session.getAttribute("username");
		if(session!=null && !(username).isEmpty()){
			
			UserDAO userDao= new UserDAO();
			try {
				User user=userDao.get(username);
				
				Set<Venue> venueList= (Set<Venue>) user.getFavVenueList();
				Iterator itr= venueList.iterator();
				while(itr.hasNext()){
					Venue venue= (Venue) itr.next();
					System.out.println("vneue add"+venue.getVenueAddress());
					System.out.println("vneue add"+venue.getVenueAddress().getAddrLine1());
				}
				mv.addObject("username", user.getFirstName()+" "+user.getLastName());
				mv.addObject("favList",user.getFavVenueList());
				mv.addObject("visitedList", user.getVisitedVenueList());
			} catch (JustAskException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mv.setViewName("favAndVisited");
		}else{
			mv.setViewName("index");
		}
		
		return mv;
	}
}
