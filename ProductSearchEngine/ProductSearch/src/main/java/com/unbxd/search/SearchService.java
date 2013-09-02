package com.unbxd.search;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.unbxd.common.type.SearchProductResponse;
import com.unbxd.common.type.SearchQueryResponse;

/**
 *
 *@author Amaresh.Mourya
 *@since 01-Sep-2013
 * 
 */
@Path("/search")
public interface SearchService {
	    @GET
	    @Path("/getProductsClickedForAQuery/{query}")
	    @Produces("application/xml")
	    public SearchProductResponse getProductsClickedForAQuery(@PathParam("query") String query) ;
	 
	    @GET
	    @Path("/getQueriesForAnArtist/{artist}")
	    @Produces("application/xml")
	    public SearchQueryResponse getQueriesForAnArtist(@PathParam("artist") String artist) ;
}
