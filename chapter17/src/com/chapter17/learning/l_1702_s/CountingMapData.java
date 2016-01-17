package com.chapter17.learning.l_1702_s;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CountingMapData extends AbstractMap<Integer,String> {

	
	@Override
	public Set<java.util.Map.Entry<Integer, String>> entrySet() {
		Set<Map.Entry<Integer, String >> entries=new LinkedHashSet<Map.Entry<Integer,String>>();
		for(int i=0;i<size;i++){
			entries.add(new MyEntry(i));
		}
		return entries;
	}

	
	private int size;
	private static String[] chars="A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
	
	public CountingMapData(int size){
		this.size=size<0?0:size;
	}
	
	private static class MyEntry implements Map.Entry<Integer, String>{
		private int index=0;
		
		MyEntry(int index){
			this.index=index;
		}
		
		@Override
		public Integer getKey() {
			return Integer.valueOf(index);
		}

		@Override
		public String getValue() {
			return chars[index % chars.length]+Integer.toString(index/chars.length);
		}

		@Override
		public String setValue(String value) {
			throw new UnsupportedOperationException();
		}
	}
	
	public static void main(String[]args){
		System.out.println(new CountingMapData(60));
	}
}
