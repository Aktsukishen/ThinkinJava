package com.chapter11.learning.l_1104_s;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 
 * Java容器库中两种主要类型：
 * Collection 和     Map
 * 其主要区别是容器中每个"槽"保存的元素的个数。
 * Collection中每个槽中只能保存一个元素，
 * Map在每个槽中保存了两个对象。
 * 
 * 
 * HashMap和HashSet都提供的最快的查找技术
 * TreeMap和TreeSet都是按照比较结果的升序进行数据存储
 * LinkedHashMap和LinkedHashSet按照数据添加的顺序来保存数据
 * 
 * @author li.shensong
 *
 */
public class PrintingContainers {
	
	static Collection fill(Collection<String> collection){
		collection.add("rat");
		collection.add("cat");
		collection.add("dog");
		collection.add("dog");
		return collection;
	}
	
	static Map fill(Map<String,String> map){
		map.put("rat","Fuzzy");
		map.put("cat","Rags");
		map.put("dog","Bosco");
		map.put("dog","Spot");
		return map;
	}
	
	public static void main(String[]args){
		System.out.println(fill(new ArrayList<String>()));
		System.out.println(fill(new LinkedList<String>()));
		//HashSet顺序没法保证
		System.out.println(fill(new HashSet<String>()));
		//TreeSet 按照比较结果的升序保存对象
		System.out.println(fill(new TreeSet<String>()));
		//LinkedHashSet 按照添加的顺序保存对象
		System.out.println(fill(new LinkedHashSet<String>()));
		
		System.out.println(fill(new HashMap<String,String>()));
		System.out.println(fill(new TreeMap<String,String>()));
		System.out.println(fill(new LinkedHashMap<String,String>()));
	}
}
