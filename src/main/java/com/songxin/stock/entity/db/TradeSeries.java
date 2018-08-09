package com.songxin.stock.entity.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TradeSeries {
    private Integer id;

    private String stockholderCode;

    private String stockCode;

    private String stockName;

    private BigDecimal profitLose;

    private BigDecimal profitPercent;

    private String tradeSummary;
    
    
    private Date seriesBegintime;
    
    private List<Integer> tradeRecordIds;

    public TradeSeries() {
    	
	}

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

    public BigDecimal getProfitLose() {
        return profitLose;
    }

    public void setProfitLose(BigDecimal profitLose) {
        this.profitLose = profitLose;
    }

    public BigDecimal getProfitPercent() {
        return profitPercent;
    }

    public void setProfitPercent(BigDecimal profitPercent) {
        this.profitPercent = profitPercent;
    }

    public String getTradeSummary() {
        return tradeSummary;
    }

    public void setTradeSummary(String tradeSummary) {
        this.tradeSummary = tradeSummary == null ? null : tradeSummary.trim();
    }

	public Date getSeriesBegintime() {
		return seriesBegintime;
	}

	public void setSeriesBegintime(Date seriesBegintime) {
		this.seriesBegintime = seriesBegintime;
	}

	public List<Integer> getTradeRecordIds() {
		return tradeRecordIds;
	}

	public void setTradeRecordIds(List<Integer> tradeRecordIds) {
		this.tradeRecordIds = tradeRecordIds;
	}
    
}