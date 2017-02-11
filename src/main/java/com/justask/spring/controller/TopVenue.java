package com.justask.spring.controller;

import java.util.Date;

public class TopVenue {

	private long venueId;
	
	private long reviewCount;
	
	private String venueName;
	
	private Date startDate;
	
	private int rating;

	public long getVenueId() {
		return venueId;
	}

	public void setVenueId(long venueId) {
		this.venueId = venueId;
	}
	

	public long getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(long reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
}
