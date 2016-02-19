package com.meiyang.aop;

public class Holder {
	
	public static ThreadLocal<String> holder = new ThreadLocal<String>(){

		@Override
		protected String initialValue() {
			// TODO Auto-generated method stub
			System.out.println("当前线程"+Thread.currentThread().getName());
			return null;
		}
		
	};
	
	public static void setHolder(String food){
		   holder.set(food);
	}
	   
	public static String getHolder(){
		   return holder.get();
	}

}
