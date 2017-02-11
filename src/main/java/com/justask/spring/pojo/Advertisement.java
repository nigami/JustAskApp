package com.justask.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="advertisementTable")
public class Advertisement {

	@Id
	@GeneratedValue
	@Column(name="advertiseId", nullable=false, unique=true)
	private long advertiseId;
	
	private int feeOfAd;
	
	private String packageOfAd;
	
	@ManyToOne(fetch= FetchType.EAGER,cascade=CascadeType.PERSIST)
	private User ownerOfAd;
	
	@OneToOne(fetch= FetchType.EAGER,cascade=CascadeType.PERSIST)
	private Venue venueOfAd;

	public Advertisement(){
		
	}
	
	public long getAdvertiseId() {
		return advertiseId;
	}

	public void setAdvertiseId(long advertiseId) {
		this.advertiseId = advertiseId;
	}

	public int getFeeOfAd() {
		return feeOfAd;
	}

	public void setFeeOfAd(int feeOfAd) {
		this.feeOfAd = feeOfAd;
	}

	public User getOwnerOfAd() {
		return ownerOfAd;
	}

	public void setOwnerOfAd(User ownerOfAd) {
		this.ownerOfAd = ownerOfAd;
	}

	public Venue getVenueOfAd() {
		return venueOfAd;
	}

	public void setVenueOfAd(Venue venueOfAd) {
		this.venueOfAd = venueOfAd;
	}

	public String getPackageOfAd() {
		return packageOfAd;
	}

	public void setPackageOfAd(String packageOfAd) {
		this.packageOfAd = packageOfAd;
	}
	
	
	
	
}
