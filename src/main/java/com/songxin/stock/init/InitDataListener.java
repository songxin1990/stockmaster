package com.songxin.stock.init;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import com.songxin.stock.service.Excel2DBService;

public class InitDataListener implements InitializingBean, ServletContextAware{

//	private UserService userService;//属性。和配置文件对应property name对应
	private Excel2DBService excel2DBService;
	private Logger log = Logger.getLogger(InitDataListener.class);
	
	
	

//	@Override
	public void afterPropertiesSet() throws Exception {
		//在这个方法里面写 初始化的数据也可以。
		
	}
//	@Override
	public void setServletContext(ServletContext arg0) {
		
		//userMap容器存放 userList（用户数据）
//		List<User> userList = new ArrayList<User>(); 
		
		try {
//			userList = userService.queryAllUser();
			
//			Map<String, Object> userMap = CachFactory.getInstance().createCach("userMap");
//一个工厂模式和单例模式的使用。文档最后有代码
//			for(User user:userList){
//				userMap.put(user.getUserid(), user);
//			}
			
		} catch (Exception e) {
			log.error("queryAllUser error系统初始化查询所有用户出错");
		}
	}	
//	System.out.println(userList.size());

}