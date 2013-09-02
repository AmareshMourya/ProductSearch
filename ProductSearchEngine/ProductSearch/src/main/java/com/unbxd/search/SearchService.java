package com.unbxd.search;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.unbxd.common.type.SearchProductResponse;
import com.unbxd.common.type.SearchQueryResponse;

/**
 * Search service interface
 *@author Amaresh.Mourya
 *@since 01-Sep-2013
 * 
 */
@Path("/search")
public interface SearchService {
	 /**
	 * 
	 * @param query, the search query
	 * @return the list of product data for given search query
	 */
	    @GET
	    @Path("/getProductsClickedForAQuery/{query}")
	    @Produces("application/xml")
	    public SearchProductResponse getProductsClickedForAQuery(@PathParam("query") String query) ;
	 
	    /**
	     * 
	     * @param artist, the artist name
	     * @return the list of queries that resulted in product selection for a given artist
	     */
	    @GET
	    @Path("/getQueriesForAnArtist/{artist}")
	    @Produces("application/xml")
	    public SearchQueryResponse getQueriesForAnArtist(@PathParam("artist") String artist) ;
}
