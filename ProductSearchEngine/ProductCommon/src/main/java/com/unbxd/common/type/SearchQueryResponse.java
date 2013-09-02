package com.unbxd.common.type;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Amaresh.Mourya
 * @since 02-Sep-2013
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchQueryResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	@XmlElement
	private Set<String> queries;

	public Set<String> getQueries() {
		return queries;
	}

	public void setQueries(Set<String> queries) {
		this.queries = queries;
	}

}
