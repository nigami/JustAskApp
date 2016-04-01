package com.justask.spring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
@PrimaryKeyJoinColumn(name="personId")
public class User extends Person{

	@Id
	@GeneratedValue
	@Column(name="userId" , unique=true, nullable=false)
	private int userId;
	
	@Column(name="username")
	@NotNull
	private String username;
	
	@Column(name="password")
	@NotNull
	private String password;

	@Column(name="userType")
	@NotNull
	private String userType;// Owner or notOwner
	
	public User(){
		
	}
	
	public User(String username, String pwd){
			this.username=username;
			password=pwd;
		}
		
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	
	
}
