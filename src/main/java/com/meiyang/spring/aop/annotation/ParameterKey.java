package com.meiyang.spring.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParameterKey {
	
	/**
	 * 生成key的方法名，默认为toString方法
	 * 
	 * @return
	 */
	public abstract String[] keyMethod() default "toString";

	/**
	 * 是否允许Key为null，默认不允许
	 * 
	 * @return
	 */
	public abstract boolean couldBeNull() default false;

}
