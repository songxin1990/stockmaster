package com.globex.baseservice.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class DubboConsumer {
	public static void main(String args[]) {
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/dubbo-consumer.xml");
	        context.start();
	 
//	        SMService smService = (SMService) context.getBean("smService");// 获取远程服务代理
//	        List<TjmSendsm> smsList = smService.findAll();// 执行远程方法
//	        System.out.println(smsList.size());
	}
}
