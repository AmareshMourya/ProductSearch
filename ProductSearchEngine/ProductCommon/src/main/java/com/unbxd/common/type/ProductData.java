package com.unbxd.common.type;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Amaresh.Mourya
 * @since 31-Aug-2013
 * 
 */

public class ProductData implements Serializable{

	private static final long serialVersionUID = 1L;
	private ProductId productId;
	private String artist;
	private String genre;
	private String productName;
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
	@Override
	public String toString() {
		return "ProductData [productId=" + productId + ", artist=" + artist
				+ ", genre=" + genre + ", productName=" + productName
				+ "]";
	}
	public Set<String> getQuerySet() {
		if( querySet == null)
			{
			   querySet = new HashSet<String>();
			}
		return querySet;
	}


}
