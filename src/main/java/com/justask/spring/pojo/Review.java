package com.justask.spring.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name="review")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name="venueId", 
        referencedColumnName="venueId"),
    @PrimaryKeyJoinColumn(name="userId",
        referencedColumnName="userId")
})
public class Review {

	@Id
	@GeneratedValue
	@Column(name="reviewId", nullable=false, unique=true)
	private String reviewId;
	
	@Column(name="venueType")
	private String venueType;
	
	@Column(name="venueId")
	private int venueId;
	
	@Column(name="dateOfReview")
	private Date dateOfReview;
	
	@Column(name="desc")
	private String description;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="costEff")
	private double costEff;
	
	@Column(name="rating")
	private int rating;

	public Review(){
		
	}
	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	
	
}
