package com.chapter15.learning.l_1504_s;

import com.chapter15.learning.l_1503_s.Generator;

public class BasicGenerator<T> implements Generator<T> {
	
	//T 表明是哪个类的Class
	private Class<T> type;
	
	public BasicGenerator(Class<T> type) {
	     this.type=type;
	}
	
	@Override
	public T next() {
		try{
			return type.newInstance();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

	public static  <T> Generator<T> create(Class<T> type){
		return new BasicGenerator<>(type);
	}
	
	
	
}
