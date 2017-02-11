package com.justask.spring.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.justask.spring.exception.JustAskException;
import com.justask.spring.pojo.Review;
import com.justask.spring.pojo.User;
import com.justask.spring.pojo.Venue;

public class ReviewDAO extends DAO{
	public ReviewDAO(){
		
	}
	
	public List<Review> getLatestReviews(User user)
	            throws JustAskException {
	        try {
	            begin();
	           /* Query addressQuery= getSession().createQuery("from Address addr where addr.country=:userCountry and addr.city=:userCity");
	            addressQuery.setString("userCountry", user.getAddress().getCountry());
	            addressQuery.setString("userCity", user.getAddress().getCity());
	            List<Address> addressList= addressQuery.list();
	            System.out.println("addressList.get(0);..."+((Address)addressList.get(0)).getAddressId());
	            
	           */
	            
	            Query q = getSession().createQuery("from Review review where review.user =:user");
	           q.setEntity("user", user);
	           List<Review> reviewsList= q.list();
	           System.out.println("addressList................");
	          
	           for(Review review: reviewsList){
	        	 System.out.println("venue..in reviewwwww..........."+review.getVenueId());
	        	 System.out.println("venue..in getReviewId..........."+review.getReviewId());
	        	 System.out.println("venue..in getDescription..........."+review.getDescription());
	        	 
	           }
	
	         /*  Query reviewQuery= getSession().createSQLQuery("select venueid, review_dtails, rank() over(partition by venueid order by review_date) from venue v, review r where v.venueid=r.venueid where rank =1");
	           reviewQuery.setParameterList("venueIdList", venueIdList);
	            List<Review> reviewsList= reviewQuery.list();
	            */
	            commit();
	            return reviewsList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new JustAskException("Could not get user " + user, e);
	        }
	    }
	
	public Review addReview(int venueId, int rating,String comment,String costEff,String username) throws JustAskException{
		 try {
	            begin();
	            System.out.println("addReview");
	            UserDAO userDao= new UserDAO();
	            User user= userDao.getUser(username);
	            
	            Review review = new Review();
	            review.setCostEff(Double.valueOf(costEff));
	            review.setDateOfReview(new Date());
	            review.setDescription(comment);
	            review.setRating(rating);
	            review.setVenueId(venueId);
	            review.setUser(user);
	            getSession().save(review);
	            System.out.println("save review");
	            commit();
	           
	            VenueDAO venueDAO= new VenueDAO();
	            Venue venue=venueDAO.getSelectedVenue(String.valueOf(venueId));
	            System.out.println("venuid"+venueId);
	            System.out.println("venue"+venue);
	            System.out.println("outside IntroVenue"+ venue.getIntroVenueReview());
            	
	            if(venue!=null && venue.getIntroVenueReview()==null){
	            	System.out.println("inside IntroVenue"+ venue.getIntroVenueReview());
	            	venue.setIntroVenueReview(comment);
	            	begin();
	            	getSession().save(venue);
	            	commit();
	            	System.out.println("saved IntroVenue");	            	
	            }
	           
	            return review;
	        } catch (HibernateException e) {
	            rollback();
	            throw new JustAskException("Could not get user " + username, e);
	        }
	}
	
	public boolean deleteReview(int reviewId){
		boolean status= false;
		
		try{
			begin();
			Query deleteQuery= getSession().createQuery("delete from Review where reviewId=:reviewId");
			deleteQuery.setInteger("reviewId", reviewId);
			int review =  deleteQuery.executeUpdate();
			commit();
			System.out.println("review delete count......."+review);
			if(review>0){
				status=true;
			}
			
		}catch(HibernateException he){
			rollback();
			he.printStackTrace();
		}
		return status;
	}
	

	
	public Review getReview(int reviewId, String username) throws JustAskException{
		 try {
	            begin();
	            System.out.println("getReview");
	            
	             
	            Query q = getSession().createQuery("from Review review where review.reviewId =:reviewId");
		        q.setInteger("reviewId", reviewId);
		        Review review= (Review) q.uniqueResult();
		         
	            System.out.println("save review");
	            commit();
	            return review;
	        } catch (HibernateException e) {
	            rollback();
	            throw new JustAskException("Could not get user " + username, e);
	        }
	}
	
	
	public Review updateReview(int reviewId,int  rating,double costEff,String desc) throws JustAskException{
		 try {
	            begin();
	            System.out.println("getReview");
	            
	             
	            Query q = getSession().createQuery("from Review review where review.reviewId =:reviewId");
		        q.setInteger("reviewId", reviewId);
		        Review review= (Review) q.uniqueResult();
		         
		        review.setCostEff(costEff);
		        review.setDateOfReview(new Date());
		        review.setDescription(desc);
		        review.setRating(rating);
		        
	            System.out.println("save review");
	            commit();
	            return review;
	        } catch (HibernateException e) {
	            rollback();
	            throw new JustAskException("Could not get user " +e);
	        }
	}
	 
	
	public List<Review> getVenueSpecificReviews(String venueId) throws JustAskException{
		 try {
	            begin();
	            System.out.println("getReview");
	            
	             
	            Query q = getSession().createQuery("from Review review where review.venueId =:venueId");
		        q.setInteger("venueId", Integer.valueOf(venueId));
		        List<Review> reviewlist= q.list();
		         
	            System.out.println("save review");
	            commit();
	            return reviewlist;
	        } catch (HibernateException e) {
	            rollback();
	            throw new JustAskException("Could not get venue with id " + venueId, e);
	        }
	}
	
	
	
}
