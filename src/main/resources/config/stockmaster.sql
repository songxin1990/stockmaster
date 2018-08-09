CREATE DATABASE IF NOT EXISTS stockmaster DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

##某人的股票交易记录，excel导入
DROP TABLE IF EXISTS trade_record;
CREATE TABLE IF NOT EXISTS trade_record
(
id int  not null auto_increment,			##自增长ID
stockholder_code varchar(36) not null,		##股东代码
stock_code varchar(12) not null,			##股票代码
stock_name varchar(12) not null,			##股票名称
buy_sell_flag char(1) not null,				##买卖标志
trade_datetime datetime not null,			##成交时间
trade_price decimal(10,2) not null,			##成交价格  
trade_num  int not null,					##成交数量
trade_amount decimal(10,2)not null,			##成交金额 
trade_series_id int,						##关联trade_series表
PRIMARY KEY (id)
)ENGINE=InnoDB   DEFAULT   CHARSET=utf8;


##那这样的话，我还要设计一个Stock表,代码，名称，等？目前来看，好像不太需求，直接用的一个stock_code就区分了。

###KStock表记录股票当天的K线情况的表，比如收盘，开盘，最高价等信息的
DROP TABLE IF EXISTS k_stock;
CREATE TABLE IF NOT EXISTS k_stock
(
id int  not null auto_increment,			##自增长ID
stock_code varchar(12) not null,			##股票代码
k_date date not null,						##日期
open_price decimal(10,2) not null,			##股票开盘价格
close_price decimal(10,2) not null,			##股票收盘价格
high_price decimal(10,2) not null,			##股票当日最高价格
low_price decimal(10,2) not null,			##股票当日最低价格
adj decimal(10,2) not null,					##股票adj参数
volume bigint not null,						##股票成交量
PRIMARY KEY (id)
)ENGINE=InnoDB   DEFAULT   CHARSET=utf8;


##某人在某一天持有那些股票
DROP TABLE IF EXISTS stock_holding;
CREATE TABLE IF NOT EXISTS stock_holding
(
id int  not null auto_increment,			##自增长ID
stockholder_code varchar(36) not null,		##股东代码
market_date date not null,					##日期
stock_code varchar(12) not null,			##持有那些股票
cost_price decimal(10,2) not null,			##股票成本价格
close_price decimal(10,2) not null,			##股票收盘价格
stock_num  int not null,					##股票持仓数量
PRIMARY KEY (id)
)ENGINE=InnoDB   DEFAULT   CHARSET=utf8;

###某人在某一天的账户情况
DROP TABLE IF EXISTS stock_market_val;
CREATE TABLE IF NOT EXISTS stock_market_val
(
id int  not null auto_increment,			##自增长ID
stockholder_code varchar(36) not null,		##股东代码
market_date date not null,					##日期
asset_val decimal(10,2) not null,			##资产值
market_val decimal(10,2) not null,			##股票市值
paper_profit decimal(10,2) not null,		##浮动盈亏
actual_profit decimal(10,2) not null,		##实际盈亏（以每一次平仓为准）
PRIMARY KEY (id)
)ENGINE=InnoDB   DEFAULT   CHARSET=utf8;

###一系列的交易记录
DROP TABLE IF EXISTS trade_series;
CREATE TABLE IF NOT EXISTS trade_series
(
id int  not null auto_increment,			##自增长ID
stockholder_code varchar(36) not null,		##股东代码
stock_code varchar(12) not null,			##持有那些股票
stock_name varchar(12) not null,			##股票名称
series_begintime datetime not null,			##交易记录开始时间
profit_lose decimal(10,2) not null,			##盈亏
profit_percent decimal(4,2) not null,		##实际盈亏幅度，百分比
trade_summary  varchar(1000),				##交易总结
PRIMARY KEY (id)
)ENGINE=InnoDB   DEFAULT   CHARSET=utf8;


