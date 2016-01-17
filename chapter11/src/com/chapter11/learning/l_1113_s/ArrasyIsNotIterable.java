package com.chapter11.learning.l_1113_s;

import java.util.Arrays;

/**
 *
 * foreach可以遍历数组，但不是说数组就是Iterable,或者数组实现了Iterable
 *
 */
public class ArrasyIsNotIterable {

	static <T> void test(Iterable<T> iterable){
		for(T t:iterable){
			System.out.print(t+"\t");
		}
	}
	
	public static void main(String[] args) {
		test(Arrays.asList(1,2,3));
		String[] strs=new String[]{"A","B","C"};
//		test(strs);
		test(Arrays.asList(strs));
	}

}
