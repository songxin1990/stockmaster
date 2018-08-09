package com.songxin.stock.entity.db;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * 作用：交易记录
 * @author Administrator
 * @date 2016年3月5日
 */
public class TradeRecord {
    private Integer id;

    private String stockholderCode;

    private String stockCode;

    private String stockName;

    private String buySellFlag;

    private Date tradeDatetime;

    private BigDecimal tradePrice;

    private Integer tradeNum;

    private BigDecimal tradeAmount;
    
    
    private Integer tradeSeriesId;
    
    private Integer isProcessed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockholderCode() {
        return stockholderCode;
    }

    public void setStockholderCode(String stockholderCode) {
        this.stockholderCode = stockholderCode == null ? null : stockholderCode.trim();
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName == null ? null : stockName.trim();
    }

    public String getBuySellFlag() {
        return buySellFlag;
    }

    public void setBuySellFlag(String buySellFlag) {
        this.buySellFlag = buySellFlag == null ? null : buySellFlag.trim();
    }

    public Date getTradeDatetime() {
        return tradeDatetime;
    }

    public void setTradeDatetime(Date tradeDatetime) {
        this.tradeDatetime = tradeDatetime;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    public Integer getTradeNum() {
        return tradeNum;
    }

    public void setTradeNum(Integer tradeNum) {
        this.tradeNum = tradeNum;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

	public Integer getTradeSeriesId() {
		return tradeSeriesId;
	}

	public void setTradeSeriesId(Integer tradeSeriesId) {
		this.tradeSeriesId = tradeSeriesId;
	}

	public Integer getIsProcessed() {
		return isProcessed;
	}

	public void setIsProcessed(Integer isProcessed) {
		this.isProcessed = isProcessed;
	}
    @Override
    public String toString() {
    	
    	
    	return new StringBuilder().append("股票代码:").append(stockCode).append(",股票名称:").append(stockName).toString();
    }
    
}