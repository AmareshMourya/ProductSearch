package com.unbxd.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.unbxd.common.type.ProductData;
import com.unbxd.common.type.ProductId;
import com.unbxd.common.type.SearchProductResponse;
import com.unbxd.common.type.SearchQueryResponse;
import com.unbxd.storage.ProductDataProvider;

/**
 * Implementation of Search Service
 *@author Amaresh.Mourya
 *@since 01-Sep-2013
 * 
 */

public class SearchServiceImpl implements SearchService{

	// ProductDataProvider that executes on stored map in memory 
	@Autowired
	private ProductDataProvider dataProvider;
	
	public SearchProductResponse getProductsClickedForAQuery(String query) {
		SearchProductResponse response =  new SearchProductResponse();
		if(query != null && query.length() > 0)
		{
			List<ProductData> list = new ArrayList<ProductData>();
			Map<ProductId, ProductData> productMasterData = dataProvider.getProductMasterData();
    	    Map<String, List<ProductId>> queryMap = dataProvider.getQueryToProductMap();
			List<ProductId> products = queryMap.get(query);
			if(products != null && products.size()> 0)
			{
				for(ProductId id: products)
				{
					list.add(productMasterData.get(id));
				}
			}
			response.setProducts(list);
		}
		return response;
	}

	public SearchQueryResponse getQueriesForAnArtist(String artist) {
		
		SearchQueryResponse response =  new SearchQueryResponse();
		if(artist != null && artist.length() > 0)
		{
			// Set to avoid duplicates
			Set<String> querySet = new HashSet<String>();
			Map<String, List<ProductId>> artistToProductMap = dataProvider.getArtistToProductMap();
			Map<ProductId, ProductData> productMasterData = dataProvider.getProductMasterData();
			List<ProductId> products = artistToProductMap.get(artist);
			if(products != null && products.size()> 0)
			{
				for(ProductId id: products)
				{
					ProductData data =  productMasterData.get(id);
					if(data != null && data.getQuerySet().size() > 0)
					{
						querySet.addAll(data.getQuerySet());
				    }
				}
			}
			response.setQueries(querySet);
		}
		return response;
	}

}
