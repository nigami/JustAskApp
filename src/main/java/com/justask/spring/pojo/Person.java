package com.justask.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="personSampleTable")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {

	@Id
	@Column(name="personID",unique=true, nullable=false)
	@GeneratedValue
	private long personId;
	
	@NotNull
	@Size(min=4,max=15)
	@NotEmpty(message = "Please enter your First Name")
	private String firstName;
	
	private String lastName;
	
	@Email
	@NotNull(message= "Please enter your Email id")
	private String email;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade= CascadeType.ALL)
	//@JoinColumn(name="personId")
	
	private Address address;	
	 
	public Person(){
		address= new Address();
	}
	
	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonIgnore
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
