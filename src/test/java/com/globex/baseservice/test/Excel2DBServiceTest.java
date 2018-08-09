package com.globex.baseservice.test;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.util.FileUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.songxin.stock.service.Excel2DBService;
import com.songxin.stock.util.EmptyUtil;

import junit.framework.TestCase;

public class Excel2DBServiceTest extends TestCase {

	
	private static Excel2DBService excel2DBService;
	private static ApplicationContext act;
	static{
		act = new ClassPathXmlApplicationContext(new String[]{"config/spring.xml","config/spring-mybatis.xml"});
		excel2DBService = (Excel2DBService) act.getBean("excel2DBService");
	}
	
	public void testexcel2Mysql(){
		String fileDir = "D://Workspace//stock//stock-master//src//main//resources//excel";
		File file = new File(fileDir);
		
		File[] excels = FileUtil.listFiles(file, new FileFilter() {
			
			public boolean accept(File arg0) {
				return true;
			}
		});
		
		if(!EmptyUtil.isEmpty(excels)){
			for(File excel:excels){
				excel2DBService.excel2Mysql(excel);
			}
		}
		
	}
}
