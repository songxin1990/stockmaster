package com.songxin.stock.util;

import java.util.ArrayList;
import java.util.List;

import com.songxin.stock.entity.excel.TradeRecordExcel;

public class EmptyUtil {

	
	public static boolean isEmpty(Object[] objs){
		return null==objs||objs.length<=0?true:false;
		
	}

	public static <T> boolean isEmpty(List<T> list) {
		return null==list||list.size()<=0?true:false;
	}
	
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("xx");
		EmptyUtil.isEmpty(list);
//		System.out.println(EmptyUtil.isEmpty(list));
	}
}
