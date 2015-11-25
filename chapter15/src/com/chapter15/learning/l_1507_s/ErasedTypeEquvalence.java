package com.chapter15.learning.l_1507_s;

import java.util.ArrayList;

/**
 * 
 * 类型参数不能作为判断对象是否相同的标准
 * @author Administrator
 *
 */
public class ErasedTypeEquvalence {

	public static void main(String[] args) {
		Class s1=new ArrayList<String>().getClass();
		Class s2=new ArrayList<Integer>().getClass();
		System.out.println(s1==s2);
	}

}
