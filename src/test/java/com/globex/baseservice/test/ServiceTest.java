package com.globex.baseservice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.songxin.stock.service.Excel2DBService;
import com.songxin.stock.service.ProcessService;

import junit.framework.TestCase;

public class ServiceTest extends TestCase{

	public static Excel2DBService excel2DBService;
	public static ProcessService processService;
	private static ApplicationContext act;
	static{
		act = new ClassPathXmlApplicationContext(new String[]{"config/spring.xml","config/spring-mybatis.xml"});
		excel2DBService = (Excel2DBService) act.getBean("excel2DBService");
		
		processService = (ProcessService) act.getBean("processService");
	}
	
}
