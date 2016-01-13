package com.chapter11.learning.l_1113_s;

import java.util.Iterator;

/**
 * 
 * 能够进行foreach的遍历都是实现了Iterable的接口
 * @author Administrator
 *
 */
public class IterableClass implements Iterable<String>{

	protected String[] words=("And that us how we know the earth ti be banana-shaped").split(" ");
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
			
			@Override
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static void main(String[]args){
		for(String s:new IterableClass()){
			System.out.print(s+" ");
		}
	}
	

}
