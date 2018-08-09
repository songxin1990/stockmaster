package com.songxin.stock.schedule;


import java.io.Serializable;
import java.util.Date;
/**
 * 每天的报告
 * @author 3gods.com
 *
 */
public class Report implements Serializable{

	private static final long serialVersionUID = 1L;
	private Date date;
	//股票市值
	private double marketValue;

	//浮盈
	private double paperProfit;

	public double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}

	public double getPaperProfit() {
		return paperProfit;
	}

	public void setPaperProfit(double paperProfit) {
		this.paperProfit = paperProfit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
