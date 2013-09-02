package com.unbxd.test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;

import com.unbxd.common.type.ProductData;
import com.unbxd.common.type.ProductId;
import com.unbxd.storage.ProductDataProvider;

/**
 *
 *@author Amaresh.Mourya
 *@since 01-Sep-2013
 * 
 */

public class Searcher {

	String dataFile  =    
			"D://devel/workspace-testing/data/data.json";
	String queryFile  =    
			"D://devel/workspace-testing/data/part1.json";
	ProductDataProvider provider= null;
	public Searcher()
	{
		try {
		 provider= new ProductDataProvider(dataFile, queryFile );
		} catch (FileNotFoundException e) {
			
		} catch (JSONException e) {
	
		}
	}
	
	public static void main(String[] args) {
     Searcher seracher =  new Searcher();
     seracher.getProductsClickedForAQuery("Hooverphonic");
     seracher.getQueriesForAnArtist("Infest");
	}
	
	public List<ProductData> getProductsClickedForAQuery(String query)
	{
		List<ProductData> list = new ArrayList<ProductData>();
		if(query != null && query.length() > 0)
		{
			Map<ProductId, ProductData> productMasterData = provider.getProductMasterData();
    	    Map<String, List<ProductId>> queryMap = provider.getQueryToProductMap();
			List<ProductId> products = queryMap.get(query);
			if(products != null && products.size()> 0)
			{
				for(ProductId id: products)
				{
					list.add(productMasterData.get(id));
				}
			}
		}
		System.out.println(list);
		
		return list;
	}
	
	public Set<String> getQueriesForAnArtist(String artist)
	{
		Set<String> list = new HashSet<String>();
		if(artist != null && artist.length() > 0)
		{
			Map<String, List<ProductId>> artistToProductMap = provider.getArtistToProductMap();
			Map<ProductId, ProductData> productMasterData = provider.getProductMasterData();
			
			List<ProductId> products = artistToProductMap.get(artist);
			if(products != null && products.size()> 0)
			{
				for(ProductId id: products)
				{
					ProductData data =  productMasterData.get(id);
					if(data != null && data.getQuerySet().size() > 0)
					{
						list.addAll(data.getQuerySet());
				    }
				}
			}
		}
	 System.out.println(list);
		return list;
	}


}
