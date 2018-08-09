package com.globex.baseservice.test;

import java.io.File;
import java.util.List;

import com.songxin.stock.entity.excel.TradeRecordExcel;
import com.songxin.stock.excel.ExcelHelper;
import com.songxin.stock.excel.HssfExcelHelper;
import com.songxin.stock.excel.JxlExcelHelper;

public class TestExcelService {
	
	public static void main(String[] args) {
		
		String fileDir = "D://Workspace//stock//stock-master//src//main//resources//excel//wtzs.xls";
		File excel = new File(fileDir);
//		ExcelHelper excelHelper = JxlExcelHelper.getInstance(excel);
		ExcelHelper excelHelper = HssfExcelHelper.getInstance(excel);
//		ExcelHelper excelHelper = JxlExcelHelper.getInstance(excel);

		String[] fieldNames = new String[]
//				{"stockholderCode","stockCode","stockName","buySellFlag","tradeDate","tradeTime","tradePrice","tradeNum","tradeAmount","tradeNo","delegatedNo"};
				{"stockName","tradeDate","tradeTime","buySellFlag","tradePrice","tradeNum","tradeAmount","tradeNo","delegatedNo","stockCode","stockholderCode"};
		try {
			List<TradeRecordExcel> tradeOrderList = excelHelper.readExcel(TradeRecordExcel.class, fieldNames, 0, true);
			//数据处理
//			System.out.println(tradeOrderList.size());
			//插入数据库
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
