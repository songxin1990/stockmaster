package com.songxin.stock.entity.excel;

import java.io.Serializable;
import java.util.Date;

	
public class TradeRecordExcel implements Serializable{

	private static final long serialVersionUID = 1754187212407163414L;

	//股东代码
	private String stockholderCode;
	//证券代码
	private String stockCode;
	//证券名称
	private String stockName;
	//买卖标志(买入，卖出)
	private String buySellFlag;
	//成交日期
	private String tradeDate;
//	private Date tradeDate;
	//成交时间
	private String tradeTime;
	//成交价格
	private String tradePrice;
//	private Double tradePrice;
	//成交数量
	private String tradeNum;
	//成交金额
	private String tradeAmount;
	//成交编号
	private String tradeNo;
	//委托编号
	private String delegatedNo;
	public String getStockholderCode() {
		return stockholderCode;
	}
	public void setStockholderCode(String stockholderCode) {
		this.stockholderCode = stockholderCode;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getBuySellFlag() {
		return buySellFlag;
	}
	public void setBuySellFlag(String buySellFlag) {
		this.buySellFlag = buySellFlag;
	}
	
	public String getTradePrice() {
		return tradePrice;
	}
	public void setTradePrice(String tradePrice) {
		this.tradePrice = tradePrice;
	}
	public String getTradeAmount() {
		return tradeAmount;
	}
	public void setTradeAmount(String tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getDelegatedNo() {
		return delegatedNo;
	}
	public void setDelegatedNo(String delegatedNo) {
		this.delegatedNo = delegatedNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getTradeDate() {
		//这里格式化下？
		return tradeDate;
	}
	public void setTradeDate(String tradeDate) {
		//那么可不可以在这个地方搞下？比如先格式成Date然后
		//这里也格式话下？
		this.tradeDate = tradeDate;
	}
	public String getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}
	public String getTradeNum() {
		return tradeNum;
	}
	public void setTradeNum(String tradeNum) {
		this.tradeNum = tradeNum;
	}

}
