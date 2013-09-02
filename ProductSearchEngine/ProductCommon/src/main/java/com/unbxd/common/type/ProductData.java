package com.unbxd.common.type;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * ProductData class that contains a product's attributes 
 * @author Amaresh.Mourya
 * @since 31-Aug-2013
 * 
 */

public class ProductData implements Serializable{

	private static final long serialVersionUID = 1L;
	// These will be populated while processing data.json
	private ProductId productId;
	private String artist;
	private String genre;
	private String productName;
	// This will be populated while processing query.json, added here to minimize object creation
	// Set to avoid duplicates
	private Set<String> querySet;
	
	
	public ProductId getProductId() {
		return productId;
	}
	public void setProductId(ProductId productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public Set<String> getQuerySet() {
		if( querySet == null) // lazy initialization
			{
			   querySet = new HashSet<String>();
			}
		return querySet;
	}
	
	@Override
	public String toString() {
		return "ProductData [productId=" + productId + ", artist=" + artist
				+ ", genre=" + genre + ", productName=" + productName
				+ "]";
	}


}
