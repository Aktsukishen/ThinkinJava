package com.chapter11.learning.l_1113_s;

import java.util.Arrays;

/**
 *
 * foreach���Ա������飬������˵�������Iterable,��������ʵ����Iterable
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
