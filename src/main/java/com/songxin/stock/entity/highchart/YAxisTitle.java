package com.songxin.stock.entity.highchart;
import java.io.Serializable;

/**
 * DESC 这个是YAxis下面的title
 * @author Administrator
 *
 */
public class YAxisTitle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String text;
//	private int margin;
//	private int offset;
//	private int rotation;
//	private Style style;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
//	public int getMargin() {
//		return margin;
//	}
//	public void setMargin(int margin) {
//		this.margin = margin;
//	}
//	public int getOffset() {
//		return offset;
//	}
//	public void setOffset(int offset) {
//		this.offset = offset;
//	}
//	public int getRotation() {
//		return rotation;
//	}
//	public void setRotation(int rotation) {
//		this.rotation = rotation;
//	}
//	public Style getStyle() {
//		return style;
//	}
//	public void setStyle(Style style) {
//		this.style = style;
//	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
