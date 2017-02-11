package com.justask.spring.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.justask.spring.dao.ReviewDAO;
import com.justask.spring.dao.UserDAO;
import com.justask.spring.pojo.Review;
import com.justask.spring.pojo.User;
import com.justask.spring.utils.CommonUtilsConstant;

@Controller
public class UpdateProfileController {


	@RequestMapping(value="/updateProfile.htm",method = RequestMethod.GET)
	public String updateProfileFormBacking(HttpServletRequest request, ModelMap model) throws Exception	{
		
		HttpSession session = request.getSession();
		String username= (String)session.getAttribute("username");
		User user;
		
		UserDAO userDao= new UserDAO();
		user=userDao.get(username);
		
		ReviewDAO reviewDao=new ReviewDAO();
		List<Review> reviewList= reviewDao.getLatestReviews(user);
		
		model.addAttribute("username", (user.getFirstName()+" "+user.getLastName()));
		model.addAttribute("user", user);	
		model.addAttribute("reviewList",reviewList);
			
		return CommonUtilsConstant.UPDATEPROFILE;
	}
	
	
	@RequestMapping(value="/updatePersonalProfile.htm",method= RequestMethod.POST)
	public String updatePersonalProfile(HttpServletRequest request, HttpServletResponse response) throws Exception	{
		
		HttpSession session = request.getSession();
		String username= (String)session.getAttribute("username");
			
		String newFirstName = (String) request.getParameter("firstname");
		String newLastName = (String) request.getParameter("lastname");
		String newEmail=(String) request.getParameter("email");
			System.out.println("I got user with name"+newFirstName +"lastname..."+newLastName+"email..."+newEmail);
			UserDAO userDao= new UserDAO();
			String status=userDao.updatePersonalProfile(newFirstName,newLastName,newEmail,username);
			
			JSONObject json = new JSONObject();
			json.put("status",status);
			
			PrintWriter out=response.getWriter();
			out.print(json);
			
		
			System.out.println("I  get user");
	
		
		//model.addAttribute("user", user);	
			
		return null;
	}
	
	@RequestMapping(value="/updateAccountProfile.htm",method= RequestMethod.POST)
	public String updateAccountProfile(HttpServletRequest request, HttpServletResponse response) throws Exception	{
		boolean returnValue= false;
		HttpSession session = request.getSession();
		String username= (String)session.getAttribute("username");
		String paramName = request.getParameter("parameterName");
		String paramValue= request.getParameter("parameterValue");
			System.out.println("I got user with parameter ");
			UserDAO userDao= new UserDAO();
			String status=userDao.updateAccountProfile(paramName,paramValue,username);
			if(status.equalsIgnoreCase("success")){
				returnValue=true;
				if(paramName.equalsIgnoreCase("newusername")){
					session.setAttribute("username", paramValue);
				}
			}
			JSONObject json = new JSONObject();
			json.put("status",returnValue);
			json.put("param", paramName);
			PrintWriter out=response.getWriter();
			out.print(json);
			
		
		return null;
	}
	
	
	@RequestMapping(value="/updateAddressProfile.htm",method= RequestMethod.POST)
	public String updateAddressProfile(HttpServletRequest request, HttpServletResponse response) throws Exception	{
		
		HttpSession session = request.getSession();
		String username= (String)session.getAttribute("username");
		//User userUpdated = (User) request.getAttribute("user");
			System.out.println("I got user with address");
			UserDAO userDao= new UserDAO();
			//addr1: addrLine1,addr2: addrLine2,city:addrCity,state:addrState,country:addrCnty, zip:zipcde
			String addr1= request.getParameter("addr1");
			String addr2= request.getParameter("addr2");
			String city= request.getParameter("city");
			String state= request.getParameter("state");
			String country= request.getParameter("country");
			String zip= request.getParameter("zip");
			
			String status=userDao.updateAddressProfile(addr1,addr2,city,state,country,zip,username);
						
			PrintWriter out=response.getWriter();
			out.print(status);
			
		return null;
	}
	
	
	@RequestMapping(value="/availableUsername.htm",method= RequestMethod.POST)
	public String availableUsername(HttpServletRequest request, HttpServletResponse response) throws Exception	{
		System.out.println("inside availableUsername method");
		HttpSession session = request.getSession();
		String usernameNew= (String)request.getParameter("findUsername");
		System.out.println("new usernmae.......:     "+usernameNew);
		String usernameOld = (String) session.getAttribute("username");
		boolean result=false;
			//System.out.println("I got user with name"+ user.getFirstName());
			UserDAO userDao= new UserDAO();
			User user=userDao.get(usernameNew);
			if(user==null || usernameNew.equalsIgnoreCase(usernameOld)){
				System.out.println("result.......:");
				result=true;
			}
			
			PrintWriter out=response.getWriter();
			out.print(result);
			
						
		return null;
	}
	
	
	
	@RequestMapping(value="/checkPasswordOld.htm",method= RequestMethod.POST)
	public String checkPasswordOld(HttpServletRequest request, HttpServletResponse response) throws Exception	{
		System.out.println("inside availableUsername method");
		HttpSession session = request.getSession();
		String currentpwd= (String)request.getParameter("currentpwd");
		String username = (String) session.getAttribute("username");
		boolean result=false;
			//System.out.println("I got user with name"+ user.getFirstName());
			UserDAO userDao= new UserDAO();
			User user=userDao.get(username);
			if(user!=null && currentpwd.equalsIgnoreCase(user.getPassword())){
				result=true;
			}
			
			PrintWriter out=response.getWriter();
			out.print(result);
						
		return null;
	}
}
