package com.globex.baseservice.test;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.songxin.stock.service.Excel2DBService;

public class ProcessServiceTest extends ServiceTest{

	
	public void testgetTradeSeries(){
		try {
			processService.getTradeSeries();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
