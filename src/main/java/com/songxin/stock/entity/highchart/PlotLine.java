package com.songxin.stock.entity.highchart;
import java.io.Serializable;

public class PlotLine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String color;
	
//	private String dashStyle;
	
//	private Object events;
	
//	private String id;
	
//	private Lable label;
	
	private int value;
	
	private int width;
	
//	private int zindex;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

//	public int getZindex() {
//		return zindex;
//	}
//
//	public void setZindex(int zindex) {
//		this.zindex = zindex;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
}
