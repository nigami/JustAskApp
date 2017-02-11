
package com.justask.spring.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.StopFilterFactory;
import org.apache.lucene.analysis.ngram.NGramFilterFactory;
import org.apache.lucene.analysis.standard.StandardFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;

@Entity
@Indexed(index="AddressIndexes")	
@Table(name="addresstable")
public class Address {

	@Id
	@GeneratedValue
	private int addressId;
	
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Analyzer(definition="justAskAnalyzer")
	@NotNull	
	private String addrLine1;
	
	private String addrLine2;
	
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Analyzer(definition="justAskAnalyzer")
	private String city;
	
	private String country;
	
	private String state;
	
	private int zipcode;
	
	private String addrCategory;
	
	public Address(){
		
	}

	public Address getAddress(){//String addr1, String addr2, String city, String country, String state, int zipcde
		return new Address();
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddrCategory() {
		return addrCategory;
	}

	public void setAddrCategory(String addrCategory) {
		this.addrCategory = addrCategory;
	}
	
	
	
}
