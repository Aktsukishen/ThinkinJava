package com.chapter15.learning.l_1504_s;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {

	public static <T> List<T> makeList(T...args){
		List<T> list=new ArrayList<T>();
		for(T item:args){
			list.add(item);
		}
		return list;
	}

	public static void main(String[]args){
		List<String> ls=makeList("A");
		System.out.println(ls);
		ls=makeList("A","B");
		System.out.println(ls);
		ls=makeList("ABCBD".split(""));
		System.out.println(ls);
	}
}
