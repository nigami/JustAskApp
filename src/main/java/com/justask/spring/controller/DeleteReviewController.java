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
import com.justask.spring.exception.JustAskException;
import com.justask.spring.pojo.Review;
import com.justask.spring.pojo.User;

@Controller
public class DeleteReviewController {

	@RequestMapping(value="/deleteReview.htm",method=RequestMethod.POST)
	public String deleteReviewHandler(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		String username= (String) session.getAttribute("username");
		
		
		int reviewId= Integer.valueOf(request.getParameter("reviewIndex"));
		
		ReviewDAO reviewDao = new ReviewDAO();
		//boolean status= reviewDao.deleteReview(reviewId);
		Review reviewToDelete;
		try {
			reviewToDelete = reviewDao.getReview(reviewId,username);
			//reviewToDelete.setUser(new User());
			System.out.println("reviewId"+reviewToDelete.getUser().getUsername());
		
		} catch (JustAskException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		boolean status= reviewDao.deleteReview(reviewId);
		System.out.println("review deleted");
		PrintWriter out;
			try {
				out = response.getWriter();
				out.print(status);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}
	
	
}

