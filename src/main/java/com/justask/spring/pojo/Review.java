package com.justask.spring.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="review")
public class Review {

	@Id
	@GeneratedValue
	@Column(name="reviewId", nullable=false, unique=true)
	private int reviewId;
	
	@Column(name="venueType")
	private String venueType;
		
	@Column(name="dateOfReview")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfReview;
	
	@Column(name="reviewDesc")
	private String description;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	@Column(name="costEff")
	private double costEff;
	
	@Column(name="rating")
	private int rating;
	/*
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="venue")
	private Venue venue;
	*/
	
	private  int venueId;
	
	@Transient
	private String venueName;
	
	public Review(){
		
	}


	public int getReviewId() {
		return reviewId;
	}


	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}


	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	public Date getDateOfReview() {
		return dateOfReview;
	}

	public void setDateOfReview(Date dateOfReview) {
		this.dateOfReview = dateOfReview;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getCostEff() {
		return costEff;
	}

	public void setCostEff(double costEff) {
		this.costEff = costEff;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getVenueType() {
		return venueType;
	}
	public void setVenueType(String venueType) {
		this.venueType = venueType;
	}
/*	
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}*/
}
