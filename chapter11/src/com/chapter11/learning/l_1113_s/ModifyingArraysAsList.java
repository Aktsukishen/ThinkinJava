package com.chapter11.learning.l_1113_s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ModifyingArraysAsList {

	public static void main(String[] args) {
		Random rand=new Random(47);
		Integer[] a={1,2,3,4,5,6,7,8,9,10};
		
		List<Integer> list1=new ArrayList<Integer>(Arrays.asList(a));//new时使用数据的拷贝
		System.out.println("Before shufffing:"+list1);
		Collections.shuffle(list1, rand);
		System.out.println("After shuffing:"+list1);
		System.out.println("array:"+Arrays.asList(a));
		
		List<Integer> list2=Arrays.asList(a);//直接使用原始数据
		System.out.println("Before shuffing:"+list2);
		Collections.shuffle(list2, rand);
		System.out.println("After shuffing:"+list2);
		System.out.println("Arrays:"+Arrays.asList(a));
	}

}
