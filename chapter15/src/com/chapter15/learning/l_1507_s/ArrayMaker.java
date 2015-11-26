package com.chapter15.learning.l_1507_s;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<T> {

	private Class<T> kind;
	
	public ArrayMaker(Class<T> kind){this.kind=kind;}
	
	@SuppressWarnings("unchecked")
	T[] create(int size) {
//		T t=kind.newInstance();此处直接返回类型T,并没有进行数据转型
		return (T[])Array.newInstance(kind, size);//此处先换入kind(object)然后在进行类型转换，故最终转换为Null
		
	}
	
	public static void main(String[]args){
		ArrayMaker<String> stringMaker=new ArrayMaker<>(String.class);
		String[] stringArray=stringMaker.create(9);
		System.out.println(Arrays.toString(stringArray));
	}
}
