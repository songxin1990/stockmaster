package com.songxin.stock.service;

import java.io.File;

import com.songxin.stock.entity.ResultMsg;


//将excel插入到数据库中的服务，并删除excel文件，需要封装一个消息类
public interface Excel2DBService {

	
	ResultMsg  excel2Mysql(File file);
	
}
