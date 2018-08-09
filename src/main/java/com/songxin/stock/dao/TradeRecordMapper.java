package com.songxin.stock.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.songxin.stock.entity.db.TradeRecord;

public interface TradeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TradeRecord record);

    int insertSelective(TradeRecord record);

    TradeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TradeRecord record);

    int updateByPrimaryKey(TradeRecord record);
    
    List<TradeRecord> selectAll();
    
    List<String> selectDistinctCode();

    List<TradeRecord> selective(@Param("stockCode")String stockCode,@Param("isProcessed")Integer isProcessed,@Param("orderByField") String orderByField);
    
}