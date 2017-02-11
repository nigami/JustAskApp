package com.justask.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.justask.spring.dao.ReviewDAO;
import com.justask.spring.pojo.Review;

@Controller
public class AddReviewController {

	
	@RequestMapping(value = "/addReviewComments.htm", method = RequestMethod.POST)
	public String addVenueToUserHandler(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("insude addVenueToUserHandler");
			int venueId= Integer.valueOf(request.getParameter("reviewVenueId"));
			int rating= Integer.valueOf(request.getParameter("reviewRating"));
			String comment= request.getParameter("reviewComment");
			String costEff= request.getParameter("reviewCostEff");
			System.out.println("insude....."+venueId+"..."+rating+"..."+comment+"..."+costEff+"...");
			ReviewDAO reviewDao = new ReviewDAO();
			
			HttpSession session= request.getSession();
			String username=	(String) session.getAttribute("username");
		    Review review = reviewDao.addReview(venueId,rating,comment,costEff,username);
		    PrintWriter out = response.getWriter();
		    if(review!=null){
		    	out.print( true);
			}else{
				out.print( false);
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	


}
