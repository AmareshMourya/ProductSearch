package com.unbxd.storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.unbxd.common.type.ProductData;
import com.unbxd.common.type.ProductId;

/**
 *
 *@author Amaresh.Mourya
 *@since 01-Sep-2013
 * 
 */

public class ProductDataProvider {
	
	private static Map<ProductId, ProductData> masterDataMap = null;
	private static Map<String, List<ProductId>> artistToProductMap = null;
	private static Map<String, List<ProductId>> queryToProductMap = null;
	
	public ProductDataProvider(String dataFile, String queryFile) throws FileNotFoundException, JSONException
	{
		initializeMasterData(dataFile);
		initializeQueryData(queryFile);
	}
	
	private void initializeMasterData(String file) throws JSONException, FileNotFoundException {
		masterDataMap = new HashMap<ProductId, ProductData>();
		artistToProductMap = new HashMap<String, List<ProductId>>();
		InputStreamReader reader =  new InputStreamReader(new FileInputStream(file));
		JSONTokener tokener = new JSONTokener(reader);
		long start = System.currentTimeMillis();
		JSONArray jsonMasterArray = new JSONArray(tokener);
		if(jsonMasterArray != null)
		{
			final int length =  jsonMasterArray.length();
			System.out.println("Master Data length: "+ length);
			for(int i =0; i<length; i++)
			{
				JSONObject object = jsonMasterArray.getJSONObject(i);
				if(object != null)
				{
					int id = object.getInt("productId");
					String productName = object.getString("productName");
					String artist = object.getString("artist");
					String genre = object.getString("genre");
					ProductId prodId = new ProductId(id);
					ProductData data = new ProductData();
					data.setProductId(prodId);
					data.setArtist(artist);
					data.setGenre(genre);
					data.setProductName(productName);
					masterDataMap.put(prodId, data);
					
					Object objectList = artistToProductMap.get(artist);
					if(objectList != null)
					{
						@SuppressWarnings("unchecked")
						List<ProductId> productList = (List<ProductId>)objectList;
						productList.add(prodId);
					}
					else
					{
						List<ProductId> productList = new ArrayList<ProductId>();
						productList.add(prodId);
						artistToProductMap.put(artist, productList);
					}
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("Time taken in processing master data: " + (end-start)/1000+ " seconds");	
		}
	}
	
	private void initializeQueryData(String file) throws JSONException, FileNotFoundException {
		queryToProductMap= new HashMap<String, List<ProductId>>();
		InputStreamReader reader =  new InputStreamReader(new FileInputStream(file));
		JSONTokener tokener = new JSONTokener(reader);
		long start = System.currentTimeMillis();
		JSONArray jsonQueryArray = new JSONArray(tokener);
		if(jsonQueryArray != null)
		{
			final int length =  jsonQueryArray.length();
			System.out.println("Query Data length: "+ length);
			for(int i =0; i<length; i++)
			{
				JSONObject object = jsonQueryArray.getJSONObject(i);
				if(object != null)
				{
					int id = object.getInt("productId");
					String query = object.getString("query");
					ProductId prodId = new ProductId(id);
					Object listObject = queryToProductMap.get(query);
					if(listObject != null)
					{
						@SuppressWarnings("unchecked")
						List<ProductId> productList = (List<ProductId>)listObject;
						productList.add(prodId);
					}
					else
					{
						List<ProductId> productList = new ArrayList<ProductId>();
						productList.add(prodId);
						queryToProductMap.put(query, productList);
					}
					// Add query in master data map
					Object prodObject = masterDataMap.get(prodId);
					if(prodObject != null)
					{
						ProductData data = (ProductData)prodObject;
						data.getQuerySet().add(query);
					}
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("Time taken in processing query data: " + (end-start)/1000+ " seconds");	
		}
	}
	public Map<ProductId, ProductData> getProductMasterData()
	{
	    return masterDataMap;
   }

	public  Map<String, List<ProductId>> getArtistToProductMap() {
		return artistToProductMap;
	}

	public  Map<String, List<ProductId>> getQueryToProductMap() {
		return queryToProductMap;
	}	
}
