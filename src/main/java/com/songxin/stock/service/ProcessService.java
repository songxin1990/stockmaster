package com.songxin.stock.service;

import java.util.List;

import com.songxin.stock.entity.db.StockMarketVal;
import com.songxin.stock.entity.db.TradeSeries;


public interface ProcessService {
	
//	List<StockMarketVal> getStockMarketVal(String stockholderCode);
	List<StockMarketVal> getStockMarketVal();
	
	List<TradeSeries> getTradeSeries() throws Exception; 
}
