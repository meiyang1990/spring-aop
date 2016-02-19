package com.meiyang.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = new FileSystemXmlApplicationContext("e:/appContext.xml");
    	PersonService personService = appContext.getBean(PersonService.class);
    	String personName = "张国荣";
    	personService.addPerson(personName);
//    	personService.deletePerson(personName);
//    	personService.editPerson(personName);

    }
}
