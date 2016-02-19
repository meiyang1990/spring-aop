package com.meiyang.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {
	@Pointcut("execution(* com.meiyang.spring.aop.*Service*.*(..))")
	public void pointCut() {
	}

	@After("pointCut()")
	public void after(JoinPoint joinPoint) {
		System.out.println("事后处理after aspect executed");
	}

	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		//如果需要这里可以取出参数进行处理
		//Object[] args = joinPoint.getArgs();
		System.out.println("事前处理before aspect executing");
	}

	@AfterReturning(pointcut = "pointCut()", returning = "returnVal")
	public void afterReturning(JoinPoint joinPoint, Object returnVal) {
		System.out.println("后面返回afterReturning executed, return result is "
				+ returnVal);
	}

	@Around("pointCut()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("之前around start..");
		try {
			Object[] args = pjp.getArgs();
			for(Object o : args){
				System.out.println("======参数为:"+o);
			}
			
			pjp.proceed();
		} catch (Throwable ex) {
			System.out.println("error in around");
			throw ex;
		}
		System.out.println("之后around end");
	}

	@AfterThrowing(pointcut = "pointCut()", throwing = "error")
	public void afterThrowing(JoinPoint jp, Throwable error) {
		System.out.println("异常抛出error:" + error);
	}
}
