package com.justask.spring.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="usertable")
@PrimaryKeyJoinColumn(name="personId")
public class User extends Person{
	
	@Column(name="username")
	@NotEmpty(message = "Please enter your Username")
	@Size(min=4,max=40,message="Length is not proper")
	private String username;
	
	@Column(name="password")
	@Size(min=4 ,max=8,message="Length is not proper")
	@NotEmpty(message = "Please enter your Password")
	private String password;
	
	@Column(name="userType")
	//@NotNull
	private String userType;// Owner or notOwner
	
	private boolean blacklist;
	
	@Column(name="createDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name = "user_fav_venue", catalog = "justaskprojdb", joinColumns = { 
			@JoinColumn(name = "personId", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "venueId", 
					nullable = false, updatable = false) })
	@JsonManagedReference
	private Set<Venue> favVenueList= new HashSet<Venue>(0);
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name = "user_visited_venue", catalog = "justaskprojdb", joinColumns = { 
			@JoinColumn(name = "personId", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "venueId", 
					nullable = false, updatable = false) })
	@JsonManagedReference
	private Set<Venue> visitedVenueList= new HashSet<Venue>(0);
	
	
	public User(){
		
	}
	
	public Set<Venue> getVisitedVenueList() {
		return visitedVenueList;
	}

	public void setVisitedVenueList(Set<Venue> visitedVenueList) {
		this.visitedVenueList = visitedVenueList;
	}
	
	
	public User(String username, String password){
		this.username= username;
		
		this.password= password;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Set<Venue> getFavVenueList() {
		return favVenueList;
	}

	public void setFavVenueList(Set<Venue> favVenueList) {
		this.favVenueList = favVenueList;
	}

	public boolean isBlacklist() {
		return blacklist;
	}

	public void setBlacklist(boolean blacklist) {
		this.blacklist = blacklist;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
	
}
