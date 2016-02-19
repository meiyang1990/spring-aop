package com.meiyang.spring.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
	
    public static void main( String[] args )throws Exception
    {
    	ApplicationContext appContext = new FileSystemXmlApplicationContext("e:/appContext.xml");
    	appContext.getBean(TagAdvice.class);
    	IFruitService fService = (IFruitService)appContext.getBean("fService");
    	fService.eat("苹果");
    	

    	

    }

}
