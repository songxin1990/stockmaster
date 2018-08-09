package com.songxin.stock.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.songxin.stock.dao.TradeRecordMapper;
import com.songxin.stock.entity.ResultMsg;
import com.songxin.stock.entity.db.TradeRecord;
import com.songxin.stock.entity.excel.TradeRecordExcel;
import com.songxin.stock.excel.ExcelHelper;
import com.songxin.stock.excel.JxlExcelHelper;
import com.songxin.stock.service.Excel2DBService;
import com.songxin.stock.util.EmptyUtil;
@Service("excel2DBService")
public class Excel2DBServiceImpl implements Excel2DBService{
	private static Logger logger = Logger.getLogger(Excel2DBServiceImpl.class);  
	
	@Autowired
	private TradeRecordMapper tradeRecordMapper;
	

	public ResultMsg excel2Mysql(File file) {
		ResultMsg resultMsg = null;
		
		if(null==file){
			resultMsg = new ResultMsg("参数file为空!");
			return resultMsg;
		}
		//遍历，得到Excel文件
		ExcelHelper excelHelper  = null;
			//将excel转行成对象
			excelHelper = JxlExcelHelper.getInstance(file);

			String[] fieldNames = new String[]
//					{"stockholderCode","stockCode","stockName","buySellFlag","tradeDate","tradeTime","tradePrice","tradeNum","tradeAmount","tradeNo","delegatedNo"};
					{"stockName","tradeDate","tradeTime","buySellFlag","tradePrice","tradeNum","tradeAmount","tradeNo","delegatedNo","stockCode","stockholderCode"};
			try {
				List<TradeRecordExcel> tradeOrderList = excelHelper.readExcel(TradeRecordExcel.class, fieldNames, 0, true);
				
				if(EmptyUtil.isEmpty(tradeOrderList)){
					resultMsg = new ResultMsg("excel为空!");
					return resultMsg;
				}
				SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhh:mm:ss");
				//数据处理
				List<TradeRecord> tradeRecordList = new ArrayList<TradeRecord>(tradeOrderList.size());
				TradeRecord tradeRecord = null;
//				String stockHolderCodeFinal = tradeOrderList.get(0).getStockholderCode();
				String[] strs = new String[2];
				//从list中获取沪深的股东代码并拼接为一个。
				for(TradeRecordExcel tradeRecordExcel:tradeOrderList){
					String stockHolderCode = tradeRecordExcel.getStockholderCode();
					if(stockHolderCode.startsWith("A")){
						if(strs[0]==null){
							strs[0] = stockHolderCode;
						}
					}else{
						if(strs[1]==null){
							strs[1] = stockHolderCode;
						}
					}
					if(strs[0]!=null&&strs[1]!=null){
						break;
					}
				}
				String stockHolderCodeFinal = strs[0]+strs[1];
				
				for(TradeRecordExcel tradeRecordExcel:tradeOrderList){
					tradeRecord = new TradeRecord();
					
					tradeRecord.setStockholderCode(stockHolderCodeFinal);
					tradeRecord.setStockCode(tradeRecordExcel.getStockCode());
					tradeRecord.setStockName(tradeRecordExcel.getStockName());
					String flag = tradeRecordExcel.getBuySellFlag();
					if(flag.equals("买入")){
						tradeRecord.setBuySellFlag("b");
					}else if(flag.equals("卖出")){
						tradeRecord.setBuySellFlag("s");
					}
					String tradeDateTimeStr = tradeRecordExcel.getTradeDate()+tradeRecordExcel.getTradeTime();
					Date tradeDateTime = sf.parse(tradeDateTimeStr);
					tradeRecord.setTradeDatetime(tradeDateTime);
//					tradeRecord.setTradePrice(Double.parseDouble(tradeRecordExcel.getTradePrice()));
					tradeRecord.setTradePrice(new BigDecimal(tradeRecordExcel.getTradePrice()));
					tradeRecord.setTradeNum(Integer.parseInt(tradeRecordExcel.getTradeNum()));
					tradeRecord.setTradeAmount(new BigDecimal(tradeRecordExcel.getTradeAmount()));
					
					tradeRecordList.add(tradeRecord);
				}
				//插入数据库
//				tradeRecordList调用dao，这个后面肯定要改进
				for(TradeRecord tradeRecordTemp :tradeRecordList){
					tradeRecordMapper.insert(tradeRecordTemp);
				}
				
				resultMsg =  new ResultMsg(false,"file目录没有excel!");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return resultMsg;
	}

}
