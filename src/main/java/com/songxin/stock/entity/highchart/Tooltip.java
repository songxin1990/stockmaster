package com.songxin.stock.entity.highchart;
import java.io.Serializable;

public class Tooltip implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	private Boolean animation;
	
//	private Color backgroundColor;
	
	private String valueSuffix;

	public String getValueSuffix() {
		return valueSuffix;
	}

	public void setValueSuffix(String valueSuffix) {
		this.valueSuffix = valueSuffix;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
