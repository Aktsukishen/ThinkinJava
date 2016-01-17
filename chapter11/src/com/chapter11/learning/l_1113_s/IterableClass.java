package com.chapter11.learning.l_1113_s;

import java.util.Iterator;

/**
 * 
 * 能够进行foreach的遍历都是实现了Iterable的接口
 * Iterable<T>接口只有一个需要实现的方法 iterator<T>即返回Iterator<T> 迭代器
 * 迭代器Iterator<T> 有2个需要实现的方法hasNext()和next()
 * @author Administrator
 *
 */
public class IterableClass implements Iterable<String>{

	protected String[] words=("And that us how we know the earth to be banana-shaped").split(" ");
	
	
	public static void main(String[]args){
		for(String s:new IterableClass()){
			System.out.println(s+" ");
		}
	}


	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index=0;
			@Override
			public boolean hasNext() {
				return index<words.length;
			}

			@Override
			public String next() {
				return words[index++];
			}
			
		};
	}
	

}
