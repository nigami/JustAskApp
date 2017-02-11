package com.justask.spring.utils;

import java.util.ArrayList;
import java.util.List;

import com.justask.spring.dao.VenueDAO;
import com.justask.spring.exception.JustAskException;
import com.justask.spring.pojo.Address;
import com.justask.spring.pojo.User;
import com.justask.spring.pojo.Venue;

public class CommonUtilsMethod {

	public static List<Address> getAddressList(String country, String city){
		
		return null;
	}
	
	public static List<Venue> getVenueList(User user){
		VenueDAO venueDao= new VenueDAO();
		List<Venue> venueList= new ArrayList<Venue>();
		try {
			venueList=(List<Venue>) venueDao.getVenue(user);
		} catch (JustAskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return venueList;
	}
}
