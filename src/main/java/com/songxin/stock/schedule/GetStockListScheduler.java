package com.songxin.stock.schedule;

/**
 * 定期抓取（早上8点半）所有股票的列表
 * @author 3gods.com
 *
 */
public class GetStockListScheduler implements Runnable{
	public static final String STOCK_LIST_URL = "http://bbs.10jqka.com.cn/codelist.html";
	public void run() {
		//需要定期抓这个页面上的股票代码数据，如果有改的，需要重新加进去
		//需要网页爬虫抓取
		
		
		/**
		 * 首先要考虑的是你要一个什么东西？我需要一个Tomcat然后将项目丢上去，不停的跑
		 * 然后访问那个地址就可以看到我的资金曲线。这是第一步。
		 * 
		 * 先做出这个。
		 * 首先是持仓股票这些信息用什么保存？数据库，麻烦，算了，我看还是接用json
		 * 然后搞个工具类，可以读取json，添加数据什么的
		 * 
		 * 首先出第一个图，我现在的持股，和这一个月的图形出来。
		 * 从买入的当天开始就开始记录了。但是文件有个弊端就是容易被改。
		 * 
		 */
	}

}
