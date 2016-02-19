package com.meiyang.aop;

import org.springframework.stereotype.Service;

@Service("china")
public class China implements Person {
	
	

	
	public String eat() {
		// TODO Auto-generated method stub
		String holder = Holder.getHolder();
		return holder;
		
	}


	
	

}
