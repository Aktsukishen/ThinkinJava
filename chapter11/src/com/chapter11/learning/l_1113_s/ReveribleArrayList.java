package com.chapter11.learning.l_1113_s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * 指定迭代器
 * @author Administrator
 *
 * @param <T>
 */
public class ReveribleArrayList<T> extends ArrayList<T>{

	public ReveribleArrayList(Collection<T> c){
		super(c);
	}
	
	public Iterable<T> reversed(){//返回Iterable接口的实现
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator(){
				return new Iterator<T>() {
					private int current=size()-1;
					public boolean hasNext(){
						return current>-1;
					}
					public T next(){
						return get(current--);
					}
				};
			}
		};
	}
	
	public static void main(String[] args) {
		ReveribleArrayList<String> ral=new ReveribleArrayList<>(Arrays.asList("To be or not be".split(" ")));
		for(String s:ral){
			System.out.print(s+" ");
		}
		System.out.println();
		for(String s:ral.reversed()){
			System.out.print(s+" ");
		}
	}

}
