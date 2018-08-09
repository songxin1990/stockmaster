package com.globex.baseservice.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class TaskTest extends TestCase{
	
	private static ApplicationContext act;
	
	private static TaskTest taskTest; 
	static{
		act = new ClassPathXmlApplicationContext(new String[]{"resources/spring.xml","resources/spring-mybatis.xml"});
//		smService = (SMService) act.getBean("smService");
		taskTest = (TaskTest) act.getBean("taskTest");
	}
	
	public void test(){
		taskTest.hashCode();
		
	}

}
