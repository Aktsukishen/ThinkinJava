package com.chapter17.learning.l_1708_s;

import java.util.HashMap;

public class CountingMapData extends HashMap<Integer, String>{
	public CountingMapData(int size){
		for(int i=0;i<size;i++){
			char temp=(char)('A'+i);
			this.put(Integer.valueOf(i), (temp+"0"));
		}
	}
	public static void main(String []args){
		System.out.println(new CountingMapData(25));
	}
}
