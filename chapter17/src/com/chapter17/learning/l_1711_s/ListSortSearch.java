package com.chapter17.learning.l_1711_s;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListSortSearch {
	public static void main(String[]args){
		List<String> list=new ArrayList<String>(Utilities.list);
		list.addAll(Utilities.list);
		System.out.println("list:"+list);
		Collections.shuffle(list,new Random(47));
		System.out.println("shuffled:"+list);
		//Use ListIterator to trim off the last elements
		ListIterator<String> it=list.listIterator(10);
		while(it.hasNext()){
			it.next();
			it.remove();
		}
		System.out.println("Trimmed:"+list);
		Collections.sort(list);
		System.out.println("sorted:"+list);
		String key=list.get(7);
		//搜索
		int index=Collections.binarySearch(list, key);
		System.out.println("Location of "+key+"  is "+index);
		//指定排序比较器
		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println("Case-insensitive sorted:"+list);
		key=list.get(7);
		index=Collections.binarySearch(list, key, String.CASE_INSENSITIVE_ORDER);
		System.out.println("Location of "+key+" is "+index+", list.get("+index+")="+list.get(index));
	}
}
