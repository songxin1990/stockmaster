package com.songxin.stock.dao;

import com.songxin.stock.entity.db.TradeSeries;

public interface TradeSeriesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TradeSeries record);

    int insertSelective(TradeSeries record);

    TradeSeries selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TradeSeries record);

    int updateByPrimaryKey(TradeSeries record);
    
    int insertAndGetId(TradeSeries record);
}