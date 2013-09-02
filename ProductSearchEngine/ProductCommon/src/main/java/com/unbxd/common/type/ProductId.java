package com.unbxd.common.type;

import java.io.Serializable;

/**
 * 
 * @author Amaresh.Mourya
 * @since 31-Aug-2013
 * 
 */

public class ProductId implements Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "ProductId [value=" + value + "]";
	}

	public ProductId() {
	}

	public ProductId(Integer id) {
		this.value = id;
	}

	private Integer value;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductId other = (ProductId) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
