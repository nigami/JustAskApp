package com.justask.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.justask.spring.dao.CreateIndexSearchDAO;
import com.justask.spring.pojo.Venue;

@Controller
public class ReviewSearchController {
	
	@RequestMapping(value="/reviewSearch.htm", method=RequestMethod.POST)
	public String reviewSearchHandler(HttpServletRequest request, HttpServletResponse response){
		
		String reviewInput=request.getParameter("reviewSearchInput");
		System.out.println("reviewInput..."+reviewInput);
		List<Venue> resultList=CreateIndexSearchDAO.createSearchQuery(reviewInput);
		System.out.println("resultList..."+resultList);
		JSONObject obj = new JSONObject();

		//JSONArray JSONArray;
		int size=resultList.size();
		 if(size>0){
			/*obj.put("reviewlist", resultList);*/
			 
			// JSONArray= new JSONArray(resultList);
			//System.out.println(JSONArray);
			 Iterator<Venue> itr= (Iterator<Venue>) resultList.iterator();
				while(itr.hasNext()){
					Venue venue= itr.next();
					obj.append("resultList", venue);
				}
			System.out.println("System.out.println(JSONArray);");
		}else{
			
			
		}
		 System.out.println("data added in json...");
		try {
			PrintWriter out= response.getWriter();
			out.print(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/sampleAjax2.htm", method = RequestMethod.GET)
	public @ResponseBody List<Venue> sampleAjax1(HttpServletRequest req) {
		
		System.out.println("inside sample Ajax Ila/..................");
		String reviewInput = req.getParameter("reviewVenue");
		System.out.println("reviewInput..."+reviewInput);
		List<Venue> usersList= CreateIndexSearchDAO.createSearchQuery(reviewInput);
		ArrayList<Venue> users= new ArrayList<Venue>(usersList);
	  
		
		return usersList;
	}
	
	@RequestMapping(value="/sampleAjax1.htm", method=RequestMethod.GET)
	public String reviewSearch(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("inside sample Ajax Ila/..................");
		String reviewInput = request.getParameter("reviewVenue");
		System.out.println("reviewInput..."+reviewInput);
		List<Venue> usersList= CreateIndexSearchDAO.createSearchQuery(reviewInput);
		ArrayList<Venue> users= new ArrayList<Venue>(usersList);
	
		//System.out.println("list"+users.get(0).getVenueAddress().getAddressId());
		
		JSONObject obj = new JSONObject();
		obj.put("list", users);
		System.out.println("data added in json...");
		try {
			PrintWriter out= response.getWriter();
			out.print(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/sampleAjax.htm", method = RequestMethod.GET)
	public String sampleAjax1(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("inside sample Ajax Ila nigam/..................");
		
		String reviewInput = request.getParameter("reviewVenue");
		System.out.println("reviewInput..."+reviewInput);
		List<Venue> usersList= CreateIndexSearchDAO.createSearchQuery(reviewInput);
		/*ArrayList<Venue> users= new ArrayList<Venue>(usersList);*/
		
		JSONObject json= new JSONObject();
		
		
		JSONObject tempJson;
		JSONArray jsonArr= new JSONArray();
		for(Venue venueObj: usersList){
			tempJson= new JSONObject();
			tempJson.put("venueId", (String.valueOf(venueObj.getVenueId())));
			tempJson.put("venueName", (String)venueObj.getVenueName());
			tempJson.put("venueDesc", (String)venueObj.getVenueDesc());
			tempJson.put("abc","abc");
			//tempJson.put("addressId", venue.getVenueAddress().getAddressId());
			
			jsonArr.put(tempJson);
		}
		
		try {	
			PrintWriter out = response.getWriter();
		
			json.put("venueJSONList",jsonArr);
			out.print(json);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
