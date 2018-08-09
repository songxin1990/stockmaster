package com.songxin.stock.schedule;


import com.songxin.stock.entity.db.StockHolding;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import org.apache.commons.lang.NullArgumentException;
//import org.apache.commons.lang3.StringUtils;
//
//import com.song.stock.api.YahooStockApi;
//import com.song.stock.api.YahooStockFetcher;
//import com.song.stock.model.stock.Stock;
//import com.song.stock.model.stock.StockHolding;
//import com.song.stock.model.stock.YahooStock;
//import com.song.stock.model.time.Duration;
//import com.song.stock.util.FileUtils;
//import com.song.stock.util.PropertyUtil;
//import com.song.stock.util.Utils;

/**
 * 定时抓取当天的股票数据（下午3点15）
 *
 * @author 3gods.com
 *
 */
public class GetStockDataScheduler implements Runnable {

	// 每天跑一次得到数据，写入到文件中
	public void run() {
		Report report = getReport(getStockHoldingList());
		try {
			FileUtils.write2File("report", report, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 先做一个能用的，把这个写到文件里面
	public List<YahooStock> getPositionList() {
		List<YahooStock> positionList = new ArrayList<YahooStock>();
		// 1.获取持仓的stock列表
		String positionListStr = PropertyUtil.get("stock.holding");

		if (StringUtils.isEmpty(positionListStr)) {
			throw new NullArgumentException("NO STOCK POSITION LIST!!!");
		}

		// 2.遍历列表，获取数据
		List<String> strList = Arrays.asList(positionListStr.split(","));
		YahooStock stockTemp = null;
		for (String symbol : strList) {
			stockTemp = new YahooStock(symbol);

			positionList.add(stockTemp);
		}
		return positionList;
	}

	// 生成我想要的数据，现在就只有资金曲线和盈亏曲线
	public Report getReport(List<StockHolding> list) {
		List<YahooStock> stockList = getFilledStock(list);
		Report report = new Report();
		double marketValue = 0.00;

		double paperProfit = 0.00;
		for (int i = 0; i < list.size(); i++) {
			// 这样搞不太对哦。
			StockHolding stockHolding = list.get(i);
			YahooStock filledStock = stockList.get(i);

			int num = stockHolding.getNum();// 数量
			double cost = stockHolding.getCost();// 成本
			double close = filledStock.getClose();// 收盘价

			double profit = close - cost;// 每股收益

			marketValue += num * close;// 股票市值
			paperProfit += num * profit;// 美股收益
		}

		report.setMarketValue(marketValue);
		report.setPaperProfit(paperProfit);

		return report;
	}

	// 将配置中的文件转换为List<StockHolding>
	public static List<StockHolding> getStockHoldingList() {

		String stockListStr = PropertyUtil.get("stock.list");
		if (StringUtils.isEmpty(stockListStr)) {
			throw new NullPointerException("stock.list为空!!!");
		}

		List<StockHolding> list = new ArrayList<StockHolding>();
		String[] strs = stockListStr.split("#");
		for (int i = 0; i < strs.length; i++) {
			String[] strsTemp = strs[i].split(",");
			// 什么股
			String symbol = strsTemp[0];
			// 多少数量
			int num = Integer.valueOf(strsTemp[1]);
			// 成本，这里就按照买价算
			double cost = Double.valueOf(strsTemp[2]);

			list.add(new StockHolding(symbol, cost, num));

		}
		return list;
	}

	// 通过List<StockHolding>获取调用api之后的数据
	public static List<YahooStock> getFilledStock(List<StockHolding> list) {
		List<YahooStock> stockList = new ArrayList<YahooStock>(list.size());
		for (int i = 0; i < list.size(); i++) {
			stockList.set(i,
					YahooStockFetcher.getStock(list.get(i).getSymbol()));
		}
		return stockList;
	}

	/**
	 * if (this.scheduler != null) { logger.debug("starting log cleaner every "
	 * + logCleanupIntervalMs + " ms"); this.scheduler.scheduleWithRate(new
	 * Runnable() {
	 *
	 * public void run() { try { cleanupLogs(); } catch (IOException e) {
	 * logger.error("cleanup log failed.", e); } }
	 *
	 * }, 60 * 1000, logCleanupIntervalMs); }
	 */
	// 所有的测试写在当前类中的main方法
	public static void main(String[] args) {
		// GetStockDataScheduler scheduler = new GetStockDataScheduler();
		// List<YahooStock> list = scheduler.getPositionList();
		getStockHoldingList();

	}

}
