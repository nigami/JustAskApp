package com.justask.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.justask.spring.dao.ReviewDAO;
import com.justask.spring.dao.UserDAO;
import com.justask.spring.dao.VenueDAO;
import com.justask.spring.exception.JustAskException;
import com.justask.spring.pojo.Review;
import com.justask.spring.pojo.ReviewVenueCount;
import com.justask.spring.pojo.User;
import com.justask.spring.pojo.Venue;

@Controller
public class AdminManageUserController {

	@RequestMapping(value="/manageUser.htm", method= RequestMethod.POST)
	public ModelAndView userInfoHandler(HttpServletRequest request, HttpServletResponse response){
		System.out.println("manage User");
		UserDAO userdao= new UserDAO();
		List<User> userList= userdao.getAllUser();
		System.out.println("user list size"+userList.size());
		
		HttpSession session = request.getSession();
		String username= (String) session.getAttribute("username");
		try {
			User user= userdao.get(username);
			userList.remove(user);
		} catch (JustAskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv= new ModelAndView();
		
		
		mv.addObject("userlist",userList);
		mv.setViewName("manageUserPage");
		return mv;
	}
/*	
	@RequestMapping(value="/manageAccounts.htm", method=RequestMethod.GET)
	public void accountInfoHandlerGET(HttpServletRequest request, HttpServletResponse response){
		accountInfoHandler(request,response);
	}
	*/
	
	@RequestMapping(value="/manageAccounts.htm", method=RequestMethod.POST)
	public ModelAndView accountInfoHandler(HttpServletRequest request, HttpServletResponse response){
		System.out.println("manage account");
		ModelAndView mv= new ModelAndView();
		
		UserDAO userdao= new UserDAO();
		List<User> userList= userdao.getAllUser();
		System.out.println("user list size"+userList.size());
		
		
		getMostActiveUser(mv,userList);
		getTopVenueList(mv);
		
		mv.addObject("ila","nigam");
		mv.setViewName("manageAccountPage");
		//mv.setViewName("account");
		return mv;
	}
	
	
	/**/
	@RequestMapping(value="/deleteUser.htm", method=RequestMethod.POST)
	public String deleteUserHandler(HttpServletRequest request, HttpServletResponse response){
		System.out.println("delete user");
		UserDAO userdao = new UserDAO();
		String personId= request.getParameter("personId");
		User user;
		PrintWriter out;
		
		try {
			out= response.getWriter();
			
			String username = userdao.getUserNsmeFromPersonID(personId);
			 user= userdao.get(username);
			 
			/*int result= userdao.deleteFavAndVisited(user);
			System.err.println("result,........"+result);
			*/
			boolean status=userdao.delete(user,true);
			if(status==true){
				out.print(true);
			}else{
				out.print(false);
			}
		} catch (JustAskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	@RequestMapping(value="/unblockUser.htm", method=RequestMethod.POST)
	public String unblockUserHandler(HttpServletRequest request, HttpServletResponse response){
		System.out.println("unblock user");
		UserDAO userdao = new UserDAO();
		String personId= request.getParameter("personId");
		User user;
		PrintWriter out;
		
		try {
			out= response.getWriter();
			
			String username = userdao.getUserNsmeFromPersonID(personId);
			 user= userdao.get(username);
		
			boolean status=userdao.delete(user,false);
			if(status==true){
				out.print(true);
			}else{
				out.print(false);
			}
		} catch (JustAskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@RequestMapping(value="/analyzeUserTraffic.htm", method=RequestMethod.POST)
	public String analyzeUserTrafficHandler(HttpServletRequest request, HttpServletResponse response){
		String ila= request.getParameter("home");
		System.out.println("inside analyzsis"+ila);
		UserDAO userDao= new UserDAO();
		//String username= userDao.getUserNsmeFromPersonID(personId);
		long userCount[]=new long[12];
		try {
			PrintWriter out= response.getWriter();
			long min=0;
			long max=0;
			for(int i=0;i<12;i++){
				userCount[i] = userDao.getUserCountPerMonth(i+1);
				if(max<userCount[i]){
					max=userCount[i];
				}else if(min>userCount[i]){
					min=userCount[i];
				}
			}
			System.err.println("analyse ....."+userCount);
			JSONObject json= new JSONObject();
			/*int max=data[0];
			int min=data
			for(int count=0;count<12;count++){
				
			}*/
			json.put("userTrafficList", userCount);
			json.put("max", max);
			json.put("min", min);
			
			System.err.println("manage reviewas. json....."+json);
				//json.put("reviewlist"+personId, reviewList);
				
				out.print(json);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return null;
	}
	
	
	@RequestMapping(value="/analyzeUserData.htm", method=RequestMethod.POST)
	public String analyzeUserDataHandler(HttpServletRequest request, HttpServletResponse response){
		String ila= request.getParameter("home");
		System.out.println("inside userdata analyzsis"+ila);
		UserDAO userDao= new UserDAO();
		//String username= userDao.getUserNsmeFromPersonID(personId);
		long userCount[]=new long[12];
		try {
			PrintWriter out= response.getWriter();
			long min=0;
			long max=0;
			for(int i=0;i<12;i++){
				int year=2005+i;
				userCount[i] = userDao.getUserCountPerYear(year);
				if(max<userCount[i]){
					max=userCount[i];
				}else if(min>userCount[i]){
					min=userCount[i];
				}
			}
			System.err.println("analyse ....."+userCount);
			JSONObject json= new JSONObject();
			/*int max=data[0];
			int min=data
			for(int count=0;count<12;count++){
				
			}*/
			json.put("userDataList", userCount);
			json.put("max", max);
			json.put("min", min);
			
			System.err.println("manage reviewas. json....."+json);
				//json.put("reviewlist"+personId, reviewList);
				
				out.print(json);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return null;
	}
	
	
	@RequestMapping(value="/analyzeVenueData.htm", method=RequestMethod.POST)
	public String analyzeVenueDataHandler(HttpServletRequest request, HttpServletResponse response){
		String ila= request.getParameter("home");
		System.out.println("inside venue analyzsis"+ila);
		UserDAO userDao= new UserDAO();
		//String username= userDao.getUserNsmeFromPersonID(personId);
		long userCount[]=new long[12];
		try {
			PrintWriter out= response.getWriter();
			long min=0;
			long max=0;
			for(int i=0;i<12;i++){
				int year=2005+i;
				userCount[i] = userDao.getVenueCountPerYear(year);
				if(max<userCount[i]){
					max=userCount[i];
				}else if(min>userCount[i]){
					min=userCount[i];
				}
			}
			System.err.println("analyse ....."+userCount);
			JSONObject json= new JSONObject();
			/*int max=data[0];
			int min=data
			for(int count=0;count<12;count++){
				
			}*/
			json.put("userDataList", userCount);
			json.put("max", max);
			json.put("min", min);
			
			System.err.println("manage reviewas. json....."+json);
				//json.put("reviewlist"+personId, reviewList);
				
				out.print(json);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return null;
	}
	
	@RequestMapping(value="/analyzeReviewData.htm", method=RequestMethod.POST)
	public String analyzeReviewDataHandler(HttpServletRequest request, HttpServletResponse response){
		String ila= request.getParameter("home");
		System.out.println("inside venue analyzsis"+ila);
		UserDAO userDao= new UserDAO();
		//String username= userDao.getUserNsmeFromPersonID(personId);
		long userCount[]=new long[12];
		try {
			PrintWriter out= response.getWriter();
			long min=0;
			long max=0;
			for(int i=0;i<12;i++){
				int year=2005+i;
				userCount[i] = userDao.getReviewCountPerYear(year);
				if(max<userCount[i]){
					max=userCount[i];
				}else if(min>userCount[i]){
					min=userCount[i];
				}
			}
			System.err.println("analyse ....."+userCount);
			JSONObject json= new JSONObject();
			/*int max=data[0];
			int min=data
			for(int count=0;count<12;count++){
				
			}*/
			json.put("userDataList", userCount);
			json.put("max", max);
			json.put("min", min);
			
			System.err.println("manage reviewas. json....."+json);
				//json.put("reviewlist"+personId, reviewList);
				
				out.print(json);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return null;
	}
	
	public ModelAndView getMostActiveUser(ModelAndView mv,List<User> userList){
		long max=0;
		String maxusername = null;
		
		ReviewDAO reviewDAO= new ReviewDAO();
		try {
			for(int i=0;i<userList.size();i++){
				User user=userList.get(i);
				/*long personId= user.getPersonId();
				*/
				List<Review> reviewList;
				
					reviewList = reviewDAO.getLatestReviews(user);
					int count= reviewList.size();
					
					if(max<count){
						maxusername=user.getUsername();
					}
				
				mv.addObject("userMax",user);
				mv.addObject("usernameMax", maxusername);
			}
		} catch (JustAskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
	
	public ModelAndView getTopVenueList(ModelAndView mv){
		long max=0;
		String maxusername = null;
		
		VenueDAO venueDao= new VenueDAO();
		List<ReviewVenueCount> reviewCountList= venueDao.getReviewVenueSpecific();
		try {
			int length=0;
			if(reviewCountList.size()>5){
				length=5;
			}else{
				length=reviewCountList.size();
			}
			
			List<TopVenue> topVenueList= new ArrayList<TopVenue>();
			for(int i=0;i<length;i++){
				long venueId= (reviewCountList.get(i)).getVenueId();
				long count= (reviewCountList.get(i)).getCount();
				
				Venue venue=venueDao.getSelectedVenue( String.valueOf(venueId));
				TopVenue topVenue= new TopVenue();
				
				topVenue.setVenueId(venueId);
				topVenue.setVenueName(venue.getVenueName());
				topVenue.setReviewCount(count);
				topVenue.setStartDate(venue.getVenueCreateDate());
				topVenue.setRating(5);
				topVenueList.add(topVenue);
			}
				mv.addObject("topVenueList",topVenueList);
			//	mv.addObject("usernameMax", maxusername);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
}
