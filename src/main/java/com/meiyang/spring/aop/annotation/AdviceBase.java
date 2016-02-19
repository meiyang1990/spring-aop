package com.meiyang.spring.aop.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author chenmeiyang
 * 切面增强处理基类
 */
public class AdviceBase {
	
	protected void adviceBase(ProceedingJoinPoint pjp ,Method method , Annotation annotation ){
		Annotation[][] anArrays = method.getParameterAnnotations();
		Object[] args = pjp.getArgs();
		System.out.println("====方法："+method+"====参数为："+args);
		Class<?>[] params = method.getParameterTypes();
		for(int i=0;i<anArrays.length;i++){
			Annotation[] an = anArrays[i];
			Object arg = args[i];
			Class<?> param = params[i];
			System.out.println("==============参数类型为：==="+param);
			System.out.println("====方法："+method+"====参数"+i+args);
			for(int j=0;j<an.length;j++){
				Annotation at = an[j];
				System.out.println("========"+at);
				
				Class<?> clazz = method.getReturnType();
				System.out.println("==============返回类型为：==="+clazz);
				
			}
		}
	}

}
