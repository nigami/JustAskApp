package com.justask.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.justask.spring.dao.ReviewDAO;
import com.justask.spring.dao.UserDAO;
import com.justask.spring.exception.JustAskException;
import com.justask.spring.pojo.Review;
import com.justask.spring.pojo.User;

@Controller
public class ManageUserReviewController {
	
	@RequestMapping(value="getReviewsForUser.htm", method=RequestMethod.POST)
	public String getReviewsForUser(HttpServletRequest request, HttpServletResponse response){
		String personId= request.getParameter("personId");
		
		UserDAO userDao= new UserDAO();
		String username= userDao.getUserNsmeFromPersonID(personId);
		User user=null;
		try {
			PrintWriter out= response.getWriter();
			
			user = userDao.get(username);
			
			System.err.println("manage reviewas. user....."+user);
			JSONObject json= new JSONObject();
			if(user!=null){
				System.out.println("insde manage reviewas. user....."+user);
				ReviewDAO reviewDao= new ReviewDAO();
				List<Review> reviewList=reviewDao.getLatestReviews(user);
				JSONObject tempObj;
				JSONArray jsonArr= new JSONArray();
				for(Review review : reviewList){
					System.err.println("manage reviewas. insideloop....."+review.getReviewId());
					tempObj= new JSONObject();
					tempObj.put("reviewId", review.getReviewId());
					tempObj.put("dateOfReview",review.getDateOfReview());
					tempObj.put("costEff", review.getCostEff());
					tempObj.put("desc",review.getDescription());
					tempObj.put("venueId",review.getVenueId());
					tempObj.put("rating",review.getRating());
					tempObj.put("personId", review.getUser().getPersonId());
					
					jsonArr.put(tempObj);
				}
				
				json.put("reviewlist", jsonArr);
				System.err.println("manage reviewas. json....."+json);
				//json.put("reviewlist"+personId, reviewList);
				
				out.print(json);
			}else{
			//	out.print("User not found");
				json.put("reviewlist"+personId, "User not found");
				System.err.println("manage reviewas. else.....");
			}
		} catch (JustAskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return null;
	}
}
