package com.meiyang.spring.aop.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author chenmeiyang
 * Tag注解   增强处理类
 */
@Component
@Aspect
public class TagAdvice extends AdviceBase {
	
	@Pointcut("@annotation(com.meiyang.spring.aop.annotation.Tag)")
	public void onAdvice(){	
	}
	
	@Around("onAdvice()")
	public Object getObject(ProceedingJoinPoint pjp)throws Throwable{
		System.out.println("=======进入增强处理==");
		Object[] args = pjp.getArgs();
		for(Object o: args){
			System.out.println("=======增强处理的参数为:"+o);
		}
		
		Method currentMethod = getCurrentMethod(pjp);
		Annotation annotation = getMethodAnnotation(currentMethod, Tag.class);
		System.out.println("====currentMethod为："+currentMethod+"===annotation为：==="+annotation);
		String absKey = (String)this.quietGetFromAnnotation("absKey", annotation);
		String tag = (String)this.quietGetFromAnnotation("tag", annotation);
		System.out.println("====absKey为："+absKey+"======tag为："+tag);
		super.adviceBase(pjp, currentMethod, annotation);
		return null;
	}
	
    /**
     * chenmeiyang
     * 直接获取方法
     */
//    private Method getCurrentMethodV2(ProceedingJoinPoint pjp) throws Throwable {
//    	Signature s = pjp.getSignature();
//    	MethodSignature ms = (MethodSignature)s;
//    	Method m = ms.getMethod();
//    	System.out.println("==========="+m);
//    	return m;
//    }
	
	
    private Method getCurrentMethod(ProceedingJoinPoint pjp) throws Throwable {
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = pjp.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        return currentMethod;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Annotation getMethodAnnotation(Method method, Class annotationClass) {
        return method.getAnnotation(annotationClass);
    }
	
    private Object quietGetFromAnnotation(String methodName, Annotation annotation) {
        if (annotation == null) {
            return null;
        }
        try {
//            return annotation.annotationType().getDeclaredMethod(methodName).invoke(annotation);
        	Class<?> clazz = annotation.annotationType();
        	Method m = clazz.getDeclaredMethod(methodName);
        	return m.invoke(annotation);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }

}
