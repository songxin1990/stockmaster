package com.songxin.stock.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.songxin.stock.dao.StockMarketValMapper;
import com.songxin.stock.dao.TradeRecordMapper;
import com.songxin.stock.dao.TradeSeriesMapper;
import com.songxin.stock.entity.db.StockMarketVal;
import com.songxin.stock.entity.db.TradeRecord;
import com.songxin.stock.entity.db.TradeSeries;
import com.songxin.stock.service.ProcessService;
import com.songxin.stock.util.ArithUtil;
import com.songxin.stock.util.EmptyUtil;
@Service("processService")
public class ProcessServiceImpl implements ProcessService {

	
	private static Logger logger = Logger.getLogger(ProcessServiceImpl.class);  
	@Autowired
	private TradeRecordMapper tradeRecordMapper;
	
	@Autowired
	private  StockMarketValMapper stockMarketValMapper;
	
	@Autowired
	private  TradeSeriesMapper tradeSeriesMapper;
	
	public List<StockMarketVal> getStockMarketVal() {
		List<TradeRecord> tradeRecordList =  tradeRecordMapper.selectAll();
		if(EmptyUtil.isEmpty(tradeRecordList)){
			return null;
		}
		
		//处理数据
		/**
		 * 怎么搞了？知道那些股票，然后股票的当天收盘价格。
		 * 那么首先生成某人在某天的持仓,
		 */
		
		for(TradeRecord tradeRecord:tradeRecordList){
			
		}
		
		
		
		
		
		return null;
	}

	public List<TradeSeries> getTradeSeries() {
		//1.查询出所有没被处理的stockCode
		List<String> stockCodeList = tradeRecordMapper.selectDistinctCode();
		if(EmptyUtil.isEmpty(stockCodeList)){
			return null;
		}
//		SELECT * FROM trade_record WHERE stock_code = '600784' ORDER BY trade_datetime
		List<TradeSeries> tradeSeriesList = new ArrayList<TradeSeries>();
		for(String stockCode:stockCodeList){
			
			List<TradeRecord> tradeRecordlist = tradeRecordMapper.selective(stockCode,0, "trade_datetime");
			//小于2是因为，最少要一次买一次卖
			if(null!=tradeRecordlist&&tradeRecordlist.size()>=2){
				TradeRecord tradeRecordFirst = tradeRecordlist.get(0);
				try{
					if(!tradeRecordFirst.getBuySellFlag().equals("b")){
						throw new Exception("交易记录中第一条记录不为买入，非法数据!"+tradeRecordFirst.toString());
					}
				}catch(Exception e){
					e.printStackTrace();
					//将这条记录删除
//					tradeRecordMapper.deleteByPrimaryKey(id)
					
					continue;
				}
				
				int num = 0;
				List<Integer> tradeRecordIds = new ArrayList<Integer>();
				
				BigDecimal totalBuy = new BigDecimal(0.00);
				BigDecimal totalSell = new BigDecimal(0.00);
				Date seriesBegintime = tradeRecordlist.get(0).getTradeDatetime();
				for(int i=0;i<tradeRecordlist.size();i++){
					TradeRecord temp = tradeRecordlist.get(i);
					
					tradeRecordIds.add(temp.getId());
					int tradeNum = temp.getTradeNum();
					String flag = temp.getBuySellFlag();
					if(flag.equals("b")){
						num += tradeNum;
						totalBuy = ArithUtil.add(totalBuy, temp.getTradeAmount());
					}else if(flag.equals("s")){
						totalSell = ArithUtil.add(totalSell, temp.getTradeAmount());
						//如果之前所有的买入等于这次卖出，一条记录产生,跳出当前循环
						if(num==tradeNum){
							TradeSeries tradeSeries = new TradeSeries();
							
							List<Integer> trIds = new ArrayList<Integer>();
							trIds.addAll(tradeRecordIds);
							tradeSeries.setTradeRecordIds(trIds);
							tradeSeries.setSeriesBegintime(seriesBegintime);
							tradeSeries.setStockCode(temp.getStockCode());
							tradeSeries.setStockName(temp.getStockName());
							tradeSeries.setStockholderCode(temp.getStockholderCode());
							BigDecimal profitLose = ArithUtil.sub(totalSell, totalBuy);
							tradeSeries.setProfitLose(profitLose);
							if(profitLose.equals(new BigDecimal(0))){
								tradeSeries.setProfitPercent(new BigDecimal(0));
							}else{
								BigDecimal profitPercent = ArithUtil.div(profitLose, totalBuy);
								tradeSeries.setProfitPercent(ArithUtil.mul(profitPercent, new BigDecimal(100)));
							}
							
							tradeSeriesList.add(tradeSeries);
							//清空参数
							tradeRecordIds.clear();
							num = 0;
							profitLose = new BigDecimal(0.00);
							totalBuy = new BigDecimal(0.00);
							totalSell = new BigDecimal(0.00);
							int j = i;
							if(++j<tradeRecordlist.size()){
								seriesBegintime = tradeRecordlist.get(j).getTradeDatetime();
							}
						}else{//否则减去这个数量
							num -= tradeNum;
						}
					}else{
						logger.error("交易记录既非买入也非卖出，非法的数据!");
					}
				}
				
			}
		}
		//2.处理得到的TradeSeriesList
		if(!EmptyUtil.isEmpty(tradeSeriesList)){
			for(TradeSeries series: tradeSeriesList){
				save(series);
			}
		}
		return null;
		
	}
	@Transactional(rollbackFor = Exception.class)
	private void save(TradeSeries series) {
		if(null==series){
			return ;
		}
		tradeSeriesMapper.insertAndGetId(series);
		int seriesId = series.getId();
		List<Integer> trIds = series.getTradeRecordIds();
		for(Integer trId:trIds){
			TradeRecord record = new TradeRecord();
			record.setId(trId);
			//record.setIsProcessed(1);
			record.setTradeSeriesId(seriesId);
			tradeRecordMapper.updateByPrimaryKeySelective(record);
		}
	}

}
