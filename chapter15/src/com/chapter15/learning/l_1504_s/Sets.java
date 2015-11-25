package com.chapter15.learning.l_1504_s;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 集合工具
 * @author li.shensong
 *
 */
public class Sets {

	/**
	 * 
	 * @param a 集合1
	 * @param b 集合2
	 * @return 合集
	 */
	public static <T> Set<T> union(Set<T> a,Set<T> b){
		Set<T> result=new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	
	/**
	 * 
	 * @param a 集合1
	 * @param b 集合2
	 * @return 交集
	 */
	public static <T> Set<T> intersection(Set<T> a,Set<T>b){
	   Set<T> result=new HashSet<T>(a);
	   result.retainAll(b);
	   return result;
	}
	
	/**
	 * 
	 * @param a 集合1
	 * @param b 集合2
	 * @return 差集
	 */
	public static <T> Set<T> diff(Set<T> a,Set<T>b){
		 Set<T> result=new HashSet<T>(a);
		   result.removeAll(b);
		   return result;
	}

	/**
	 * 
	 * @param a 集合1
	 * @param b 集合2
	 * @returnn 除了 
	 */
	public static <T> Set<T> complement(Set<T> a,Set<T>b){
		 return diff(union(a, b), intersection(a, b));
	}
}
