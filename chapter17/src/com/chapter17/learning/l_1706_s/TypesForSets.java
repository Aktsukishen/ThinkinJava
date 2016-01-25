package com.chapter17.learning.l_1706_s;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * set 保证元素不重复，必须实现equals(Object o)方法
 * @author li.shensong
 *
 */
class SetType{
	int i;
	public SetType(int i){
		this.i=i;
	}
	@Override
	public boolean equals(Object o){
		return o instanceof SetType && (i==((SetType)o).i);
				
	}
	public String toString(){
		return Integer.toString(i);
	}
}

/**
 * 
 * 哈希类型，必须实现哈希码的产生hashCode();
 * @author li.shensong
 *
 */
class HashType extends SetType{
	public HashType(int i){
		super(i);
	}
	@Override
	public int hashCode(){
		return i;
	}
}

/**
 * 
 * 树类型，需要比较大小来实现插入的排序，必须实现Comparable<T> 接口
 * @author li.shensong
 *
 */
class TreeType extends SetType implements Comparable<TreeType>{
	public TreeType(int i){
		super(i);
	}
	@Override
	public int compareTo(TreeType other){
		return other.i<i?-1:(other.i==i?0:1);
	}
}

public class TypesForSets {

	static <T> Set<T> fill(Set<T> set,Class<T> type){
		try{
			for(int i=0;i<10;i++){
				set.add(type.getConstructor(int.class).newInstance(i));
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return set;
	}
	
	static <T> void test(Set<T> set,Class<T> type){
		fill(set,type);
		fill(set,type);
		fill(set,type);
		System.out.println(set);
	}
	
	public static void main(String[] args) {
		test(new HashSet<HashType>(),HashType.class);
		test(new LinkedHashSet<HashType>(),HashType.class);
		test(new TreeSet<TreeType>(),TreeType.class);
		//Things that don't work
		test(new HashSet<SetType>(),SetType.class);//既要有hashCode()，又要有equals()方法
		test(new HashSet<TreeType>(),TreeType.class);
		test(new LinkedHashSet<SetType>(),SetType.class);
		test(new LinkedHashSet<TreeType>(),TreeType.class);
		try{
			test(new TreeSet<SetType>(),SetType.class);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try{
			test(new TreeSet<HashType>(),HashType.class);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
