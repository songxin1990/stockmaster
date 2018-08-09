package com.songxin.stock.entity.db;

import java.math.BigDecimal;
import java.util.Date;

public class StockMarketVal {
    private Integer id;

    private String stockholderCode;

    private Date marketDate;

    private BigDecimal assetVal;

    private BigDecimal marketVal;

    private BigDecimal paperProfit;

    private BigDecimal actualProfit;

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

    public BigDecimal getAssetVal() {
        return assetVal;
    }

    public void setAssetVal(BigDecimal assetVal) {
        this.assetVal = assetVal;
    }

    public BigDecimal getMarketVal() {
        return marketVal;
    }

    public void setMarketVal(BigDecimal marketVal) {
        this.marketVal = marketVal;
    }

    public BigDecimal getPaperProfit() {
        return paperProfit;
    }

    public void setPaperProfit(BigDecimal paperProfit) {
        this.paperProfit = paperProfit;
    }

    public BigDecimal getActualProfit() {
        return actualProfit;
    }

    public void setActualProfit(BigDecimal actualProfit) {
        this.actualProfit = actualProfit;
    }
}