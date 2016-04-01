package com.justask.spring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="address")
public class Address {

	@GenericGenerator(name="generator",strategy="foreign",parameters=@Parameter(name="property", value="person"))
	@Id
	@GeneratedValue(generator="generator")//custom defined generator or already generate generator, mentioned in generic value
	@Column(name="addrId", unique=true, nullable=false)
	private int addrId;
	
	private String addLine1;
	
	private String addLine2;
	
	private String city;
	
	private int zipcde;
	
	private String state;
	
	private String country;
	
	private String landMark;

	@OneToOne(fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn(name="personId")
    private Person person;
	
	public Address(){
		
	}
	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}
	
	public String getAddLine1() {
		return addLine1;
	}

	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}

	public String getAddLine2() {
		return addLine2;
	}

	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcde() {
		return zipcde;
	}

	public void setZipcde(int zipcde) {
		this.zipcde = zipcde;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	
	
}
