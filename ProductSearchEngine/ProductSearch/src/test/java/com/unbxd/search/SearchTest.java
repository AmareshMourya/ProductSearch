package com.unbxd.search;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.unbxd.common.type.SearchProductResponse;
import com.unbxd.common.type.SearchQueryResponse;

/**
 * Junit testing 
 *@author Amaresh.Mourya
 *@since 01-Sep-2013
 * 
 */
@ActiveProfiles(profiles = "windows")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/service-spring-config.xml" })
public class SearchTest {
	
	@Autowired
	private SearchService service;
	
	@Test
	public void testProductsFromAQuery()
	{
		SearchProductResponse response = service.getProductsClickedForAQuery("Hooverphonic");
		Assert.notNull(response.getProducts());
		Assert.isTrue(response.getProducts().size() > 0, "No Products found");
		System.out.println(response.getProducts());
	}
	
	@Test
	public void testQueriesFromAnArtist()
	{
		SearchQueryResponse response = service.getQueriesForAnArtist("Popular");
		Assert.notNull(response.getQueries());
		Assert.isTrue(response.getQueries().size() > 0, "Queries size is zero");
		System.out.println(response.getQueries());
	}

}
