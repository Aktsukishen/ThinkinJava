package com.chapter17.learning.l_1711_s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Utilities {
	static List<String> list=Arrays.asList("one Two three Four five six one".split(" "));
	public static void main(String[] args) {
		System.out.println(list);
		//disjoint两集合没有任何相同的元素
		System.out.println("'list' disjojint(Four):"+Collections.disjoint(list, Collections.singleton("Four")));
		//max
		System.out.println("max:"+Collections.max(list));
		//min
		System.out.println("min:"+Collections.min(list));
		//max comparator
		System.out.println("max w/ comparator:"+Collections.max(list, String.CASE_INSENSITIVE_ORDER));
		System.out.println("min w/ comparator:"+Collections.min(list, String.CASE_INSENSITIVE_ORDER));
		List<String> subList=Arrays.asList("Four five six".split(" "));
		System.out.println("indexOfSublist:"+Collections.indexOfSubList(list, subList));
		System.out.println("lastIndexOfSublist:"+Collections.lastIndexOfSubList(list, subList));
		Collections.replaceAll(list, "one", "Yo");
		System.out.println("replaceAll:"+list);
		Collections.reverse(list);
		System.out.println("reverse:"+list);
		//向右移动三个单位
		Collections.rotate(list, 3);
		System.out.println("rotate:"+list);
		List<String> source=Arrays.asList("in the matrix".split(" "));
		//把容器中
		Collections.copy(list, source);
		System.out.println("copy:"+list);
		//交换位置
		Collections.swap(list, 0, list.size()-1);
		System.out.println("swap:"+list);
		//随机打乱
		Collections.shuffle(list,new Random(47));
		System.err.println("shuffle:"+list);
		//全部填充
		Collections.fill(list, "pop");
		System.out.println("fill:"+list);
		System.out.println("frequence of 'pop':"+Collections.frequency(list, "pop"));
		//拷贝填充
		List<String> dups=Collections.nCopies(3, "snap");
		System.out.println("dup:"+dups+" dups.get(0)==dups.get(1):"+dups.get(0)==dups.get(1));
		System.out.println(" 'list' disjoint 'dups':"+Collections.disjoint(list, dups));
		Enumeration<String> e=Collections.enumeration(dups);
		Vector<String> v=new Vector<String>();
		while(e.hasMoreElements())
			v.addElement(e.nextElement());
		ArrayList<String> arrayList=Collections.list(v.elements());
		System.out.println("arrayList:"+arrayList);
	}

}
