package com.justask.spring.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.justask.spring.dao.UserDAO;
import com.justask.spring.dao.VenueDAO;
import com.justask.spring.pojo.User;
import com.justask.spring.pojo.Venue;

@Controller
public class VenueSearchController {

	@RequestMapping(value = "/VenueSearch.htm", method = RequestMethod.POST)
	public String addVenueToUserHandler(@RequestParam("action") String action,
			@RequestParam("venueType") String venueType, HttpServletResponse response) {
		try {

			VenueDAO venueDao = new VenueDAO();
			List<Venue> restaurantList= new ArrayList<Venue>();
		    restaurantList = venueDao.getVenueOfVenueType(venueType);
			
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("restaurantVenueList", restaurantList);
			System.out.println(jsonObj.get("restaurantVenueList").toString());
			PrintWriter out = response.getWriter();
			out.print(jsonObj);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/venueSearchPagination.htm", method = RequestMethod.POST)
	public String addVenuePaginationHandler(@RequestParam("pageIndex") String pageIndex, HttpServletRequest request,HttpServletResponse response) {
		try {
			System.out.println("pageIndex  "+pageIndex);
			HttpSession session= request.getSession();
			String username= (String) session.getAttribute("username");
			UserDAO userDao= new UserDAO();
			User user= userDao.get(username);
			
			VenueDAO venueDao = new VenueDAO();
			List<Venue> restaurantList= new ArrayList<Venue>();
		    restaurantList = venueDao.getVenuePagination(user, Integer.valueOf(pageIndex));
			
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("restaurantVenueList", restaurantList);
			System.out.println(jsonObj.get("restaurantVenueList").toString());
			PrintWriter out = response.getWriter();
			out.print(jsonObj);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
}
