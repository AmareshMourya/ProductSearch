package com.unbxd.common.type;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 *@author Amaresh.Mourya
 *@since 02-Sep-2013
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchProductResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElement
	private List<ProductData> products;

	public List<ProductData> getProducts() {
		return products;
	}	
	public void setProducts(List<ProductData> products) {
		this.products = products;
	}


}
