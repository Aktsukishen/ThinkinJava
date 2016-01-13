package com.chapter11.learning.l_1101_s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 
 * 在往List中添加数据时使用以下方式是比较合理和方便的：
 * List<T> list=new ArrayList<T>();
 * Collections.add(list,T t1,T t2,...)
 * 或者Collections.add(list,T[] ts)
 * @author li.shensong
 *
 */
public class AddingGroups {
	public static void main(String[]args){
		Collection<Integer> collection=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		System.out.println(collection);
		Integer[] moreInts={6,7,8,9,0};
		collection.addAll(Arrays.asList(moreInts));
		System.out.println(collection);
		Collections.addAll(collection, 11,12,13,14,15);
		System.out.println(collection);
		Collections.addAll(collection, moreInts);
		System.out.println(collection);
		List<Integer> list=Arrays.asList(16,17,18,19,20);
		list.set(1, 99);
		System.out.println(list);
		list.add(21);//error Arrays.asList时其底层是数组，不能进行尺寸调整
		System.out.println(list);
	}
}
