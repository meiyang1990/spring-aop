package com.meiyang.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
public class MyDataSourceAdvice {
	
//	@Pointcut("execution(* com.meiyang.aop.*.*(..))")
	public void onAdvice(){
		
	}
	
//	@Around("onAdvice()")
	public Object onAround(ProceedingJoinPoint  point){
		
		Object target = point.getTarget();
        String method = point.getSignature().getName();

        Class<?>[] classz = target.getClass().getInterfaces();

        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(MyDataSource.class)) {
                MyDataSource data = m.getAnnotation(MyDataSource.class);
                Holder.setHolder(data.value());
            }
            
            Object[] o = point.getArgs();
            Object ret = point.proceed(o);
            return ret;
            
        } catch (Throwable e) {
            // TODO: handle exception
        	e.printStackTrace();
        }
        
		return null;
	}

}
