package com.meiyang.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
	
    public static void main( String[] args )throws Exception
    {
    	ApplicationContext appContext = new FileSystemXmlApplicationContext("e:/appContext.xml");
//    	appContext.getBean(MyDataSourceAdvice.class);
    	Person p = (Person)appContext.getBean("china");
    	
    	String result = p.eat();
    	System.out.println("============"+result);
    	
    	String result1 = p.eat();
    	System.out.println("============"+result1);

    	

    }

}
