package com.justask.spring.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.justask.spring.pojo.Address;
import com.justask.spring.pojo.Venue;

public class CreateIndexSearchDAO extends DAO {
	
	
	public static List<Venue> createSearchQuery(String input){
		FullTextSession fullTextSession = Search.getFullTextSession(getSession());
    	
		
    		System.out.println("FullTextSession.........");
        	System.out.println("FullTextSession........."+fullTextSession);
			
        	try {
				fullTextSession.createIndexer().startAndWait();//this will be used to reIndex everything sometimes, it should run periodically
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		// create native Lucene query unsing the query DSL
		// alternatively you can write the Lucene query using the Lucene query parser
		// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
			QueryBuilder venueQB = fullTextSession.getSearchFactory()
				    .buildQueryBuilder().forEntity(Venue.class).get();
			QueryBuilder AddressQB = fullTextSession.getSearchFactory()
				    .buildQueryBuilder().forEntity(Address.class).get();

				org.apache.lucene.search.Query luceneVenueQuery =venueQB.keyword().onFields("venueName","venueType").boostedTo(3).matching(input).createQuery();
				org.apache.lucene.search.Query luceneAddrQuery =AddressQB.keyword().onFields("addrLine1","city").boostedTo(3).matching(input).createQuery();
				
				System.out.println("luceneQuery....."+luceneVenueQuery+luceneAddrQuery);
					/*	venueQB.keyword()
				        .onField("history").boostedTo(3)
				        .matching("storm")
				        .createQuery();
					 */
				
				org.hibernate.Query fullTextVenueQuery = fullTextSession.createFullTextQuery(luceneVenueQuery);
				org.hibernate.Query fullTextAddressQuery = fullTextSession.createFullTextQuery(luceneAddrQuery);
				System.out.println("fullTextQuery............"+fullTextVenueQuery);
				List<Venue> result = fullTextVenueQuery.list();
				//result.addAll(fullTextAddressQuery.list());//return a list of managed objects
				System.out.println("result............"+result.size());
				/*Iterator itr= result.listIterator();
					
				while(itr.hasNext()){
					Venue venue= (Venue) itr.next();
					System.out.println("venue Id"+venue.getVenueId()+"...."+venue.getVenueName());
				}*/
		
				return result;
		
	}
}
