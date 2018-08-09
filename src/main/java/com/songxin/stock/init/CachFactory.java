package com.songxin.stock.init;

import java.util.HashMap;
import java.util.Map;

public class CachFactory {
	
	private static CachFactory cachFactory = null;
	
	//缓存已经创建的Map对象
	private Map<String,Map> factoryMap = new HashMap<String,Map>();
	
	//单例模式
	private CachFactory(){
	}
	
	//使用“懒加载”的单例模式
	public static CachFactory getInstance(){
		if(cachFactory == null){
			cachFactory = new CachFactory();
		}
		return cachFactory;
	}
	
	/**
	 * 创建key为cachName的Map对象
	 * @param cachName
	 * @return
	 */
	public Map<String,Object> createCache(String cachName){
		Map map = new HashMap<String,Object>();
		factoryMap.put(cachName, map);
		return map;
	}
	
	/**
	 * 判断是否存在key为cachName的map
	 * @param cachName
	 * @return
	 */
	public boolean isExist(String cachName){
		if(factoryMap.containsKey(cachName)){
			return true;
		}
		return false;
	}
	
	/**
	 * 获取key为cachName的map对象
	 * @param cachName
	 * @return
	 */
	public Map getMapByKey(String cachName){
		if(factoryMap.containsKey(cachName)){
			return factoryMap.get(cachName);
		}
		return null;
	}
	
	
	/*
	@org.junit.Test
	public void testabc(){
		//1、系统启动的时候从数据库中存数数据
		Map userMap = CachFactory.getInstance().createCach("user");
		userMap.put("huangbiao", "123456");
		//2、在对应的controller类中获取缓存的数据
		System.out.println(CachFactory.getInstance().getMapByKey("user").get("huangbiao"));
	}
	*/
	
}
