package com.songxin.stock.dao;

import com.songxin.stock.entity.db.StockHolding;

public interface StockHoldingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockHolding record);

    int insertSelective(StockHolding record);

    StockHolding selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockHolding record);

    int updateByPrimaryKey(StockHolding record);
}