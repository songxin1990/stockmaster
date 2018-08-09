package com.songxin.stock.entity.highchart;


import java.io.Serializable;

/**
 * DESC RGBA
 * @author Administrator
 *
 */
public class Color implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int red;
	
	private int green;
	
	private int black;
	//渐变
	private double anamorphism;
	public int getRed() {
		return red;
	}
	public void setRed(int red) {
		this.red = red;
	}
	public int getGreen() {
		return green;
	}
	public void setGreen(int green) {
		this.green = green;
	}
	public int getBlack() {
		return black;
	}
	public void setBlack(int black) {
		this.black = black;
	}
	public double getAnamorphism() {
		return anamorphism;
	}
	public void setAnamorphism(double anamorphism) {
		this.anamorphism = anamorphism;
	}
	
	
	
	
}
