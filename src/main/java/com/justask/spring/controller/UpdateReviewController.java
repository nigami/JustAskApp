package com.justask.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.justask.spring.dao.ReviewDAO;
import com.justask.spring.exception.JustAskException;
import com.justask.spring.pojo.Review;

@Controller
public class UpdateReviewController {

	
	@RequestMapping(value="updateReview.htm", method=RequestMethod.POST)
	public String updateReviewHandler(HttpServletRequest request, HttpServletResponse response){
		boolean status=false;
		String desc= request.getParameter("desc");
		int rating = Integer.valueOf(request.getParameter("rating"));
	double costEff= Double.valueOf(request.getParameter("costEff"));
		int reviewId=  Integer.valueOf(request.getParameter("id"));

		/*HttpSession session = request.getSession();
		String username=*/
		ReviewDAO reviewDao= new ReviewDAO();
		try {
			Review review=reviewDao.updateReview(reviewId, rating,costEff,desc);
			if(review!=null &&  desc.equalsIgnoreCase(review.getDescription()) ){
				status=true;
			}
			
			PrintWriter out= response.getWriter();
			out.print(status);
			
		} catch (JustAskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
}
