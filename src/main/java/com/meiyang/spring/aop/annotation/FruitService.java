package com.meiyang.spring.aop.annotation;

import org.springframework.stereotype.Service;

/**
 * @author chenmeiyang
 * 待增强Bean
 */
@Service("fService")
public class FruitService implements IFruitService{
	
	@Tag(tag="甜甜的")
	public void eat(@ParameterKey(keyMethod="toString")String fruitName){
		System.out.println("======吃的水果是："+fruitName);
	}

}
