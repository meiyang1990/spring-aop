package com.meiyang.annotation;

import java.lang.reflect.Method;

/**
 * @author chenmeiyang
 * 注解处理
 */
public class ProcessTool {

	public static void process(String clazz) {
		// TODO Auto-generated method stub
        Class targetClass = null;
        try{
        	targetClass = Class.forName(clazz);
        }catch(Exception e){
        	e.printStackTrace();
        }
        for(Method m:targetClass.getMethods()){
        	if(m.isAnnotationPresent(MyTag.class)){
        		MyTag tag = m.getAnnotation(MyTag.class);
        		System.out.println("被MyTag注解修饰的方法名称："+m.getName()+",注解内容为："+tag.name());
        	}else{
        		System.out.println("没被MyTag注解修饰的方法名称：");
        	}
        }
	}

}
