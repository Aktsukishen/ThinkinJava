package com.chapter05.learning.l_0509_s;

/**
 * 
 * 通过枚举类型的values可以获得按照定义时候的顺序产生的常量
 * 这些枚举常量都具有ordinal()方法来表征定义时的顺序
 * @author Administrator
 *
 */
public class EnumOrder {

	public static void main(String[] args) {
		for(Speciness s:Speciness.values()){
			System.out.println(s+",ordinal "+s.ordinal());
		}
	}

}
