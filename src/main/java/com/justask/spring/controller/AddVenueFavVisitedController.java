package com.justask.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.justask.spring.dao.UserDAO;
import com.justask.spring.dao.VenueDAO;
import com.justask.spring.exception.JustAskException;
import com.justask.spring.pojo.User;

@Controller
public class AddVenueFavVisitedController {

	@RequestMapping(value = "/addVenueToUserDb.htm", method = RequestMethod.POST)
	public String addVenueToUserHandler(@RequestParam("action") String action, @RequestParam("venueId") String venueId,
			HttpServletRequest request/*
										 * ,@RequestParam("username")String
										 * username
										 */, HttpServletResponse response) {
		System.out.println("action.............." + action);
		System.out.println("venueId.............." + venueId);
		String username = (String) request.getSession().getAttribute("username");
		UserDAO userDao = new UserDAO();
		User user = null;
		String dbStatus = null;
		try {
			user = (User) userDao.get(username);
			System.out.println("user.............." + user.getFirstName());
		
			if (user != null) {
				VenueDAO venueDao = new VenueDAO();
				dbStatus = venueDao.addFavVisitedVenueToUser(venueId, user, action);
			} else {
				System.out.println("Custom Error Ila:No User Found in AddVenueFavVisitedController");
			}

			JSONObject obj = new JSONObject();
			// if(dbStatus.equalsIgnoreCase("addedVenueToUser")){
			System.out.println("inside adddedVenue...........");
			obj.put("addStatus", true);
			// }else{
			// obj.put("addStatus", false);
			// }

			PrintWriter out;

			out = response.getWriter();

			out.print(obj);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
}
