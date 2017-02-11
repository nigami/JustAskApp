package com.justask.spring.pojo;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.StopFilterFactory;
import org.apache.lucene.analysis.ngram.NGramFilterFactory;
import org.apache.lucene.analysis.standard.StandardFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;
@AnalyzerDef(name = "justAskAnalyzer",
tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class ),
filters = {
  @TokenFilterDef(factory = StandardFilterFactory.class),
  @TokenFilterDef(factory = LowerCaseFilterFactory.class),
  @TokenFilterDef(factory = StopFilterFactory.class),
  @TokenFilterDef(factory = NGramFilterFactory.class,
    params = {
      @Parameter(name = "minGramSize", value = "3"),
      @Parameter(name = "maxGramSize", value = "4") } )
}
)
@Entity
@Indexed(index="VenueIndexes")
@Table(name="venue")
public class Venue {

	@Id
	@GeneratedValue
	@Column(name="venueId", nullable=false, unique=true)
	private int venueId;
	
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Analyzer(definition="justAskAnalyzer")
	private String venueName;
	
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String venueType;
	
	private String venueDesc;
	
	private String venueRange;
	
	private String venueImgLocation;
	
	@Column(name="createDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date venueCreateDate;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "favVenueList")
	@JsonBackReference
	private Set<User> favUserList = new HashSet<User>(0);
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "visitedVenueList")
	@JsonBackReference
	private Set<User> visitedUserList = new HashSet<User>(0);
	
	
	private String introVenueReview;
	/*@OneToMany(fetch=FetchType.EAGER,cascade= CascadeType.ALL,mappedBy="reviewId")
	Set<Review> reviewsList = new HashSet<Review>();
	*/
	
	@IndexedEmbedded
	@OneToOne(fetch=FetchType.LAZY,cascade= CascadeType.ALL)
	@JsonBackReference
	private Address venueAddress;
	
	public Venue(){
		
	}

	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getVenueType() {
		return venueType;
	}

	public void setVenueType(String venueType) {
		this.venueType = venueType;
	}

	public String getVenueDesc() {
		return venueDesc;
	}

	public void setVenueDesc(String venueDesc) {
		this.venueDesc = venueDesc;
	}

	public String getVenueRange() {
		return venueRange;
	}

	public void setVenueRange(String venueRange) {
		this.venueRange = venueRange;
	}

	@JsonIgnore
	public Address getVenueAddress() {
		return venueAddress;
	}

	public void setVenueAddress(Address venueAddress) {
		this.venueAddress = venueAddress;
	}

	public String getVenueImgLocation() {
		return venueImgLocation;
	}

	public void setVenueImgLocation(String venueImgLocation) {
		this.venueImgLocation = venueImgLocation;
	}

	public Set<User> getFavUserList() {
		return favUserList;
	}

	public void setFavUserList(Set<User> favUserList) {
		this.favUserList = favUserList;
	}

	public Set<User> getVisitedUserList() {
		return visitedUserList;
	}

	public void setVisitedUserList(Set<User> visitedUserList) {
		this.visitedUserList = visitedUserList;
	}

	public Date getVenueCreateDate() {
		return venueCreateDate;
	}

	public void setVenueCreateDate(Date venueCreateDate) {
		this.venueCreateDate = venueCreateDate;
	}

	public String getIntroVenueReview() {
		return introVenueReview;
	}

	public void setIntroVenueReview(String introVenueReview) {
		this.introVenueReview = introVenueReview;
	}



	/*public Set<Review> getReviewsList() {
		return reviewsList;
	}

	public void setReviewsList(Set<Review> reviewsList) {
		this.reviewsList = reviewsList;
	}
	*/
	/*@Override
	public String toString(){
		return venueName;
		
	}*/
	
}
