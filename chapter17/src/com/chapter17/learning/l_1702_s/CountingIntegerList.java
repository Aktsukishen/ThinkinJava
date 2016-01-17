package com.chapter17.learning.l_1702_s;

import java.util.AbstractList;

public class CountingIntegerList extends AbstractList<Integer> {//继承自ArrayList不设置初始值
	private int size;
	public CountingIntegerList(int size){
		this.size=size<0?0:size;
	}
	public Integer get(int index){
		return Integer.valueOf(index);
	}
	public int size(){
		return size;	
	}
	public static void main(String[]args){
		System.out.println(new CountingIntegerList(30));
	}
}
