package com.justask.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.type.LongType;

import com.justask.spring.exception.JustAskException;
import com.justask.spring.pojo.Address;
import com.justask.spring.pojo.Review;
import com.justask.spring.pojo.ReviewVenueCount;
import com.justask.spring.pojo.User;
import com.justask.spring.pojo.Venue;

public class VenueDAO extends DAO{
	public VenueDAO(){
		
	}
	
	 public List<Venue> get5Venue(User user)
	            throws JustAskException {
	        try {
	            begin();
	            Query addressQuery= getSession().createQuery("from Address addr where addr.country=:userCountry and addr.city=:userCity");
	            addressQuery.setString("userCountry", user.getAddress().getCountry());
	            addressQuery.setString("userCity", user.getAddress().getCity());
	            List<Address> addressList= addressQuery.list();
	            System.out.println("addressList.get(0);..."+((Address)addressList.get(0)).getAddressId());
	            List addressIdList= new ArrayList();
	            System.out.print("addressIdList......................");
	            for(Address address: addressList){
	            	addressIdList.add(String.valueOf(address.getAddressId()));
	            	System.out.println(address.getAddressId());
	            }
	            
	            Query q = getSession().createQuery("from Venue venue where venue.venueAddress IN(:addressIdList)").setMaxResults(9);
	            q.setParameterList("addressIdList", addressList);
	            List<Venue> venueList= q.list();
	           
	            
	           /* Query reviewList = getSession().createQuery("from Review review where review.venueId IN(:addressList)");
	            q.setParameter("addressList", addressList);
	            List<Venue> venueList= q.list();
	            */
	            commit();
	            return venueList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new JustAskException("Could not get user " + user, e);
	        }
	    }
	 
	 public List<Venue> getVenue(User user)
	            throws JustAskException {
	        try {
	            begin();
	            Query addressQuery= getSession().createQuery("from Address addr where addr.country=:userCountry and addr.city=:userCity");
	            addressQuery.setString("userCountry", user.getAddress().getCountry());
	            addressQuery.setString("userCity", user.getAddress().getCity());
	            List<Address> addressList= addressQuery.list();
	            System.out.println("addressList.get(0);..."+((Address)addressList.get(0)).getAddressId());
	            List addressIdList= new ArrayList();
	            System.out.print("addressIdList......................");
	            for(Address address: addressList){
	            	addressIdList.add(String.valueOf(address.getAddressId()));
	            	System.out.println(address.getAddressId());
	            }
	            
	            Query q = getSession().createQuery("from Venue venue where venue.venueAddress IN(:addressIdList)");
	            q.setParameterList("addressIdList", addressList);
	            List<Venue> venueList= q.list();
	           
	            
	           /* Query reviewList = getSession().createQuery("from Review review where review.venueId IN(:addressList)");
	            q.setParameter("addressList", addressList);
	            List<Venue> venueList= q.list();
	            */
	            commit();
	            return venueList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new JustAskException("Could not get user " + user, e);
	        }
	    }
	 
	 
	 public List<Venue> getVenuePagination(User user, int pageCount)
	            throws JustAskException {
	        try {
	            begin();
	            Query addressQuery= getSession().createQuery("from Address addr where addr.country=:userCountry and addr.city=:userCity");
	            addressQuery.setString("userCountry", user.getAddress().getCountry());
	            addressQuery.setString("userCity", user.getAddress().getCity());
	            List<Address> addressList= addressQuery.list();
	            System.out.println("addressList.get(0);..."+((Address)addressList.get(0)).getAddressId());
	            List addressIdList= new ArrayList();
	            System.out.print("addressIdList......................");
	            for(Address address: addressList){
	            	addressIdList.add(String.valueOf(address.getAddressId()));
	            	System.out.println(address.getAddressId());
	            }
	            
	            Query q = getSession().createQuery("select v.venueId,v.venueName,v.venueType,v.venueDesc,v.venueRange,v.venueImgLocation,v.introVenueReview from Venue v");
	            //Query q = getSession().createQuery("select v.venueId,v.venueName,v.venueType,v.venueDesc,v.venueRange,v.venueImgLocation,v.introVenueReview from Venue v where v.venueAddress IN(:addressIdList)");
	            
	            //q.setParameterList("addressIdList", addressList);
	            q.setMaxResults(5);
	            q.setFirstResult(pageCount);
	            System.out.println("query"+q);
	            List venueList= q.list();
	            System.out.println("venueList"+venueList);
	           /* Query reviewList = getSession().createQuery("from Review review where review.venueId IN(:addressList)");
	            q.setParameter("addressList", addressList);
	            List<Venue> venueList= q.list();
	            */
	            commit();
	            return venueList;
	        } catch (HibernateException e) {
	            rollback();
	            e.printStackTrace();
	            throw new JustAskException("Could not get user " + user, e);
	        }
	    }
	 
	 
	 public List<Review> getReviews(User user)
	            throws JustAskException {
	        try {
	            begin();
	            Query addressQuery= getSession().createQuery("from Address addr where addr.country=:userCountry and addr.city=:userCity");
	            addressQuery.setString("userCountry", user.getAddress().getCountry());
	            addressQuery.setString("userCity", user.getAddress().getCity());
	            List<Address> addressList= addressQuery.list();
	            System.out.println("addressList.get(0);..."+((Address)addressList.get(0)).getAddressId());
	            
	            Query q = getSession().createQuery("from Venue venue where venue.venueAddress IN(:addressIdList)");
	            q.setParameterList("addressIdList", addressList);
	            List<Venue> venueList= q.list();
	           System.out.println("addressList................"+addressList.toString());
	           List venueIdList= new ArrayList();
	           
	           for(Venue venue: venueList){
	        	 venueIdList.add(venue.getVenueId());
	        	 System.out.println("venue..in reviewwwww..........."+venue.getVenueId());
	           }
	            
/*	           System.out.print("addressIdList......................");
	            for(Address address: addressList){
	            	addressIdList.add(String.valueOf(address.getAddressId()));
	            	System.out.println(address.getAddressId());
	            }*/
	            Query reviewQuery = getSession().createQuery("from Review review where review.venueId IN(:venueIdList)");
	            reviewQuery.setParameterList("venueIdList", venueIdList);
	            List<Review> reviewsList= reviewQuery.list();
	            
	            commit();
	            return reviewsList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new JustAskException("Could not get user " + user, e);
	        }
	    }
	 
	 
	 public String addFavVisitedVenueToUser(String venueId, User user, String action){
		
		 try{
			begin();
			System.out.println("venueId"+venueId);
			Query retrieveVenueQuery=getSession().createQuery("from Venue v where v.venueId=:inputVenueId");
			retrieveVenueQuery.setInteger("inputVenueId", Integer.valueOf(venueId));
			Venue venueToAdd= (Venue) retrieveVenueQuery.uniqueResult();
			System.out.println("venueToAdd........."+venueToAdd.getVenueId());
			if(action.equalsIgnoreCase("addVenueToVisited")){
				user.getVisitedVenueList().add(venueToAdd);
				System.out.println(user.toString());
			}else if(action.equalsIgnoreCase("addVenueToFav")){
				user.getFavVenueList().add(venueToAdd);
			}
			getSession().save(user);
			System.out.println("userRec.............."+user.getFirstName()+" "+ user.getFavVenueList().size());
			commit();
			return "addedVenueToUser";
		 }catch(RuntimeException e){
			 e.printStackTrace();
			 
		 }
		return null;
	 }
	 
	 
	 
	 public String deleteFavVisitedVenueToUser(String venueId, User user, String action){
			
		 try{
			begin();
			System.out.println("venueId"+venueId);
			Query retrieveVenueQuery=getSession().createQuery("from Venue v where v.venueId=:inputVenueId");
			retrieveVenueQuery.setInteger("inputVenueId", Integer.valueOf(venueId));
			Venue venueToDelete= (Venue) retrieveVenueQuery.uniqueResult();
			System.out.println("venueToAdd........."+venueToDelete.getVenueId());
			
			if(action.equalsIgnoreCase("deleteVenueToVisited")){
				user.getVisitedVenueList().remove(venueToDelete);
				System.out.println(user.toString());
			}else if(action.equalsIgnoreCase("deleteVenueToFav")){
				user.getFavVenueList().remove(venueToDelete);
			}
			getSession().save(user);
			System.out.println("userRec.............."+user.getFirstName()+" "+ user.getFavVenueList().size());
			commit();
			return "deletedVenueFromUser";
		 }catch(RuntimeException e){
			 e.printStackTrace();
			 
		 }
		return null;
	 }
	 
	 
	 
	 public List<Venue> getVenueOfVenueType(String venueType){
			
		 try{
			begin();
			System.out.println("venueId"+venueType);
			Query getVenueTypeQuery=getSession().createQuery("select v.venueId,v.venueName,v.venueType,v.venueDesc,v.venueRange,v.venueImgLocation,v.introVenueReview from Venue v where v.venueType=:inputVenueType");
			getVenueTypeQuery.setString("inputVenueType",venueType);
			List<Venue> venueTypeList= getVenueTypeQuery.list();
			System.out.println("venueToAdd........."+venueTypeList.size());
			commit();
			return venueTypeList;
		 }catch(RuntimeException e){
			 e.printStackTrace();
			 
		 }
		return null;
	 }
	 
	 
	 public List<Venue> getAllVenues(){
		 try{
				begin();
				//System.out.println("venueId"+venueType);
				Query getVenueQuery=getSession().createQuery("from Venue");
				List<Venue> venueTypeList= getVenueQuery.list();
				System.out.println("venueToAdd........."+venueTypeList.size());
				commit();
				return venueTypeList;
			 }catch(RuntimeException e){
				 e.printStackTrace();
				 
			 }
			return null;
	 }
	 
	 
	 public String addNewVenue(Venue venue){
		 try{
		 begin();
		 getSession().save(venue);
		 commit();
		 return "success";
		 }catch(RuntimeException e){
			 rollback();
			 e.printStackTrace();
			 return "fail";
		 }
		 
	 }
	 
	 
	 public Venue getSelectedVenue(String venueIdString){
		 try{
			 begin();
			 
			 String queryString = "from Venue where venueId=:venueId";
			 Query specificVenueQuery= getSession().createQuery(queryString);
			 specificVenueQuery.setInteger("venueId", Integer.valueOf(venueIdString));
			 Venue venue=(Venue) specificVenueQuery.uniqueResult();
			 System.out.println("venue inside DAO"+venue+"venueId"+venueIdString);
			 commit();
			 return venue;
			 }catch(RuntimeException e){
				 rollback();
				 e.printStackTrace();
				 return null;
			 }
		 
	 }
	 
	 
	 public List<Review> getVenueSpecificReviews(int venueId){
			
		 try{
			begin();
			System.out.println("venueId"+venueId);
			Query getVenueIdQuery=getSession().createQuery("from Review review where review.venueId=:venueId");
			getVenueIdQuery.setInteger("venueId",Integer.valueOf(venueId));
			List<Review> reviewTypeList= getVenueIdQuery.list();
			System.out.println("venueToAdd........."+reviewTypeList.size());
			commit();
			return reviewTypeList;
		 }catch(RuntimeException e){
			 e.printStackTrace();
			 
		 }
		return null;
	 }
	 
	
	 public Long[][] getReviewCountVenueSpecific(){
			
		 try{
			begin();
			System.out.println("venueId");
			Query getReviewCountQuery=getSession().createSQLQuery(" select distinct count(*) as count,venueId as venueId from  review group by venueId order by count desc").addScalar("count", LongType.INSTANCE);
			getReviewCountQuery.setResultTransformer(new AliasToBeanResultTransformer(ReviewVenueCount.class));
			
			List<ReviewVenueCount> reviewTypeList= getReviewCountQuery.list();
			System.out.println("venueToAdd........."+reviewTypeList.size());
			Long reviewVenueCount[][]= new Long [reviewTypeList.size()][];
			int i=0;
			for(ReviewVenueCount object : reviewTypeList)
	         {
	           /* Map row = (Map)object;*/
	           System.out.println("map..."+object.getVenueId());
	           System.out.print("First Name: " + object.getCount()); 
	           /*  System.out.println(", Salary: " + row.get("venueId")); 
	            reviewVenueCount[i][0]= (Long) row.get("count");
	            reviewVenueCount[i][1]=(Long) row.get("venueId");*/
	            i++;
	         }
			commit();
			return reviewVenueCount;
		 }catch(RuntimeException e){
			 e.printStackTrace();
			 
		 }
		return null;
	 }
	 
	 
	 public List<ReviewVenueCount> getReviewVenueSpecific(){
			
		 try{
			begin();
			System.out.println("venueId");
			//select count(distinct cat.name), count(cat) from Cat cat
			Query getReviewCountQuery=getSession().createQuery(" select distinct review.venueId,count(review) from Review review "+
		             "GROUP BY review.venueId");
			
			List<Object[]> reviewTypeList= getReviewCountQuery.list();
			System.out.println("venueToAdd........."+reviewTypeList.size());
			System.out.println(reviewTypeList);
			List<ReviewVenueCount> rvcList= new ArrayList<ReviewVenueCount>();
			
			for (Object[] aRow : reviewTypeList) {
			    Integer venueId = (Integer) aRow[0];
			    Long count = (Long) aRow[1];
			   System.out.println(count + " - " + venueId);
			    ReviewVenueCount rvc= new ReviewVenueCount();
			    rvc.setCount(count);
			    rvc.setVenueId(venueId);
			    rvcList.add(rvc);
			}
			/*Long reviewVenueCount[][]= new Long [reviewTypeList.size()][];
			int i=0;
			for(ReviewVenueCount object : reviewTypeList)
	         {
	            Map row = (Map)object;
	           System.out.println("map..."+object.getVenueId());
	           System.out.print("First Name: " + object.getCount()); 
	             System.out.println(", Salary: " + row.get("venueId")); 
	            reviewVenueCount[i][0]= (Long) row.get("count");
	            reviewVenueCount[i][1]=(Long) row.get("venueId");
	            i++;
	         }*/
			commit();
			return rvcList;
		 }catch(RuntimeException e){
			 e.printStackTrace();
			 
		 }
		return null;
	 }
}
