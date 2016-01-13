package com.chapter11.learning.l_1101_s;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * Collection接口概况了序列的概念：
 * 一种存放一组对象的方式
 * @author li.shensong
 *
 */
public class SimpleCollection {

	public static void main(String[] args) {
		Collection<Integer> c=new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			c.add(i);
		}
		for(Integer i:c){
			System.out.println(i);
		}
	}

}
