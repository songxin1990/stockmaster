package com.songxin.stock.entity.highchart;
import java.io.Serializable;
import java.util.List;

/**
 * DESC这个对应的是Seris中的data
 * @author Administrator
 *
 */
public class Serie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private List data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	

}
