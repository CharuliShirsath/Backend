package com.omfys; 

import org.springframework.context.ApplicationContext; 
import org.springframework.context.support.ClassPathXmlApplicationContext; 

public class ContextProvider { 
	private static ApplicationContext context; 

	public static ApplicationContext provideContext() 
	{ 
		if(context==null) 
		{ 
			context=new ClassPathXmlApplicationContext("hibernate.cfg.xml"); 
		} 
		return context; 
	} 
} 
