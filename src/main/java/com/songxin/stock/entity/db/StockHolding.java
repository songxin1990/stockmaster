package com.songxin.stock.entity.db;

import java.math.BigDecimal;
import java.util.Date;

public class StockHolding {
    private Integer id;

    private String stockholderCode;

    private Date marketDate;

    private String stockCode;

    private BigDecimal costPrice;

    private BigDecimal closePrice;

    private Integer stockNum;

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

    public Date getMarketDate() {
        return marketDate;
    }

    public void setMarketDate(Date marketDate) {
        this.marketDate = marketDate;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }
}