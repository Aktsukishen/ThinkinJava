package com.chapter17.learning.l_1702_s;

import java.util.LinkedHashSet;
import java.util.Set;

import com.chapter15.learning.l_1503_s.Generator;

class Goverment implements Generator<String>{
	String[] foundation=("strange women lying on ponds distributing swords is no basis for a system of goerment").split(" ");
	private int index=0;
	@Override
	public String next() {
		return foundation[index++];
	}
	
}

/**
 * 
 * addAll 所有Collection的共有方法
 * @author Administrator
 *
 */
public class CollectionDataTest {

	public static void main(String[] args) {
		Set<String> set=new LinkedHashSet<>(new CollectionData<>(new Goverment(), 15));
		set.addAll(new CollectionData<>(new Goverment(), 15));
		System.out.println(set);
	}

}
