package com.justask.spring.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.justask.spring.exception.JustAskException;
import com.justask.spring.pojo.Address;
import com.justask.spring.pojo.Review;
import com.justask.spring.pojo.User;
import com.justask.spring.pojo.Venue;

public class UserDAO extends DAO {

	public UserDAO(){
		
	}
	
	 public User get(String username)
	            throws JustAskException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from User where username = :username");
	            q.setString("username", username);
	            User user = (User) q.uniqueResult();
	            commit();
	            return user;
	        } catch (HibernateException e) {
	            rollback();
	            throw new JustAskException("Could not get user " + username, e);
	        }
	    }
	 
	 public User getUser(String username)
	            throws JustAskException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from User where username = :username");
	            q.setString("username", username);
	            User user = (User) q.uniqueResult();
	            System.out.println("inside getUseraname.. username.............."+user);
	            
	            return user;
	        } catch (HibernateException e) {
	            rollback();
	            throw new JustAskException("Could not get user " + username, e);
	        }
	    }
	 
	 
	 public User authenticateUser(User inputUser)
	            throws JustAskException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from User where username = :username and password=:password");
	            q.setString("username", inputUser.getUsername());
	            q.setString("password",inputUser.getPassword());
	            User user = (User) q.uniqueResult();
	            System.out.println("inside authentic user"+user);
	            commit();
	            if(user!=null){
	            	CreateIndexSearchDAO.createSearchQuery("curry");
	            	return user;
	            }else{
	            	return null;
	            }
	        } catch (HibernateException e) {
	            rollback();
	            throw new JustAskException("Could not get authentication clear for " + inputUser.getUsername(), e);
	        }
	    }
	 
	 public User createUser(User user)
	            throws JustAskException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            //User user=new User(username,password);
	         
	            //User existUser = get(user.getUsername());
	            //if(existUser!=null){
	            //	return null;
	            //}
	            
	         /*   Venue venue= new Venue();
	             venue.setVenueDesc("LongWood");
	             venue.setVenueName("Rurry Center");
	             venue.setVenueRange("1010");
	             venue.setVenueType("R");
	             
	             Address addressSample = new Address();
		            addressSample.setAddrLine1("addLine1");
		            addressSample.setAddrLine2("addLine2");
		            addressSample.setAddrCategory("R");
		            addressSample.setCity("Boston");
		            addressSample.setCountry("USA");
		            addressSample.setState("MA");
		            addressSample.setZipcode(02120);
		            
	             venue.setVenueAddress(addressSample);
	             venue.setVenueImgLocation("b1.jpg");
	             user.getFavVenueList().add(venue);
	             user.getVisitedVenueList().add(venue);*/
	            
	             user.setCreateDate(new Date());
	             getSession().save(user);
	           /*  getSession().save(venue);
	             
	            HashSet<Review> reviewsList= new HashSet<Review>();
	             Review review1 = new Review();
	             review1.setCostEff(1000);
	             review1.setDateOfReview(new Date());
	             review1.setDescription("Nice restaurant");
	             review1.setRating(5);
	             review1.setUser(user);
	             review1.setVenueType("R");
	             review1.setVenueId(venue.getVenueId());
	             getSession().save(review1);
	             
	             
	             Review review2 = new Review();
	             review2.setCostEff(2000);
	             review2.setDateOfReview(new Date());
	             review2.setDescription("Amazing Dining restaurant!! Went twice!");
	             review2.setRating(5);
	             review2.setUser(user);
	             review2.setVenueType("R");
	             review2.setVenueId(venue.getVenueId());
	             getSession().save(review2);*/
	             
	     /*        Review review2 = new Review();
	             
	             review2.setCostEff(2000);
	             review2.setDateOfReview(new Date());
	             review2.setDescription("Very bad restaurant");
	             review2.setRating(5);
	             review2.setUser(user);
	             review2.setVenueType("R");
	             review2.setVenueId(venue);*/
	           
	           //  reviewsList.add(review1);
	           //  reviewsList.add(review2);

	            // venue.setReviewsList(reviewsList);
	           //  getSession().save(review1);
	             //
	            // getSession().save(venue);
	             
	           
	            /*User userSample= new User();
	            // userSample.setPersonSample(person);
	            userSample.setFirstName("aman");
	            userSample.setLastName("ila");
	            userSample.setEmail("email@gmail.com");
	            userSample.setUsername("aman");
	            userSample.setPassword("nigam");*/
	            
	          
	          //  userSample.setAddress(addressSample);
	          //  getSession().save(person);
	           // getSession().save(userSample);
	            System.out.println("created....................");
	            commit();
	            
	            return user;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create user " + username, e);
	            throw new JustAskException("Exception while creating user: " + e.getMessage());
	        }
	    }
	 
	   public boolean delete(User user,boolean blacklist)
	            throws JustAskException {
	        try {
	            begin();
	            user.setBlacklist(blacklist);
	            getSession().save(user);
	            commit();
	            return true;
	        } catch (HibernateException e) {
	        	
	            rollback();
	            throw new JustAskException("Could not delete user " + user.getFirstName(), e);
	        }
	        
	      
	    }
	   
	   
	   public String updatePersonalProfile(String newFirstName,String newLastName,String newEmail,String username){
		   try {
	            begin();
	            Query q = getSession().createQuery("from User where username = :username");
	            q.setString("username", username);
	            User user = (User) q.uniqueResult();
				user.setFirstName(newFirstName);
				user.setLastName(newLastName);
				user.setEmail(newEmail);
				getSession().update(user);
				commit();
	            return "success";
	        } catch (HibernateException e) {
	            rollback();
	            e.printStackTrace();
			}
		   return "fail";
	   }
	   
	   public String updateAccountProfile(String paramName,String paramValue,String username){
		  
		   try {
	            begin();
	            UserDAO userDao= new UserDAO();
	            System.out.println("inside DAO...."+paramName+"......"+paramValue);
				User user= userDao.getUser(username);
				if(paramName.equalsIgnoreCase("newusername")&&!paramValue.isEmpty()){
					user.setUsername(paramValue);
					System.out.println("inside userupdate");
					
				}else if(paramName.equalsIgnoreCase("newpassword")&&!paramValue.isEmpty()){
					user.setPassword(paramValue);
					System.out.println("inside password");
				}else{
					return "fail";
				}
				//getSession().update(user);
				commit();
				System.out.println("COMMITTED.........!");
	            return "success";
	        } catch (HibernateException e) {
	            rollback();
	            e.printStackTrace();
			} catch (JustAskException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   return "fail";
	   }
	   
	   public String updateAddressProfile(String addr1,String addr2,String city,String state,String country,String zip,String username){
		   try {
	            begin();
	            UserDAO userDao= new UserDAO();
	            
				User user= userDao.getUser(username);
				user.getAddress().setAddrLine1(addr1);
				user.getAddress().setAddrLine2(addr2);
				user.getAddress().setCity(city);
				user.getAddress().setState(state);;
				user.getAddress().setCountry(country);
				user.getAddress().setZipcode(Integer.valueOf(zip));
				getSession().update(user);
				commit();
	            return "success";
	        } catch (HibernateException e) {
	            rollback();
	            e.printStackTrace();
			} catch (JustAskException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   return "fail";
	   }
	   
	   
	   public List<User> getAllUser(){
		   try {
	            begin();
	            Query q = getSession().createQuery("from User");
	           
	            List<User> userlist = q.list();
				commit();
	            return userlist;
		   } catch (HibernateException e) {
	            rollback();
	            e.printStackTrace();
		   } 
		   return null;
	   }
	   
	   
	   public String getUserNsmeFromPersonID(String personId){
		   try {
	            begin();
	            Query q = getSession().createSQLQuery("select username from usertable where personId=?");
	            q.setInteger(0, Integer.valueOf(personId));
	            
	            String username = (String) q.uniqueResult();
	            System.out.println("userin method..."+username);
				commit();
	            return username;
		   } catch (HibernateException e) {
	            rollback();
	            e.printStackTrace();
		   } 
		   return null;   
	   }
	   
	   public int deleteFavAndVisited(User user){
		   try {
	            begin();
	            Query q = getSession().createSQLQuery("delete from user_fav_venue where personId=?");
	            q.setInteger(0, (int) user.getPersonId());
	            
	            int count = q.executeUpdate();
	            System.out.println("userin method..."+count);
				commit();
	            return count;
		   } catch (HibernateException e) {
	            rollback();
	            e.printStackTrace();
		   } 
		   return 0;   
	   
		   
	   }
	   
	   public long getUserCountPerMonth(int month){
		   try {
	            begin();
	            Query q = getSession().createSQLQuery("SELECT count(*) FROM usertable WHERE MONTH(createDate) = ?");
	            q.setInteger(0, month);
	            
	            long userCount = ((Number) q.uniqueResult()).longValue();
	            System.out.println("usercount"+userCount);
	           
				commit();
	            return userCount;
		   } catch (HibernateException e) {
	            rollback();
	            e.printStackTrace();
		   } 
		   return 0;  
	   }
	   
	   
	   public long getUserCountPerYear(int year){
		   try {
	            begin();
	            Query q = getSession().createSQLQuery("SELECT count(*) FROM usertable WHERE YEAR(createDate) = ?");
	            q.setInteger(0, year);
	           
	            long userCount = ((Number) q.uniqueResult()).longValue();
	            System.out.println("usercount"+userCount);
	           
				commit();
	            return userCount;
		   } catch (HibernateException e) {
	            rollback();
	            e.printStackTrace();
		   } 
		   return 0;  
	   }
	   
	   
	   public long getVenueCountPerYear(int year){
		   try {
	            begin();
	            Query q = getSession().createSQLQuery("SELECT count(*) FROM venue WHERE YEAR(createDate) = ?");
	            q.setInteger(0, year);
	           
	            long userCount = ((Number) q.uniqueResult()).longValue();
	            System.out.println("usercount"+userCount);
	           
				commit();
	            return userCount;
		   } catch (HibernateException e) {
	            rollback();
	            e.printStackTrace();
		   } 
		   return 0;  
	   }
	   
	   
	   public long getReviewCountPerYear(int year){
		   try {
	            begin();
	            Query q = getSession().createSQLQuery("SELECT count(*) FROM review WHERE YEAR(dateOfReview) = ?");
	            q.setInteger(0, year);
	           
	            long userCount = ((Number) q.uniqueResult()).longValue();
	            System.out.println("usercount"+userCount);
	           
				commit();
	            return userCount;
		   } catch (HibernateException e) {
	            rollback();
	            e.printStackTrace();
		   } 
		   return 0;  
	   }
	   
}


