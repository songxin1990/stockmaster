package com.songxin.stock.dao;

import com.songxin.stock.entity.db.StockMarketVal;

public interface StockMarketValMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockMarketVal record);

    int insertSelective(StockMarketVal record);

    StockMarketVal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockMarketVal record);

    int updateByPrimaryKey(StockMarketVal record);
}