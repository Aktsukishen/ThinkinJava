package com.chapter11.learning.l_1113_s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MultiIterableClass extends IterableClass{
	
	public Iterable<String> reversed(){
		return new Iterable<String>(){
			@Override
			public Iterator<String> iterator(){
				return new Iterator<String>(){
					int current=words.length-1;
					public boolean hasNext(){
						return current>-1;
					}
					public String next(){
						return words[current--];
					}
				};
			}
		};
	}
	
	public Iterable<String> randomized(){
		return new Iterable<String>(){
			@Override
			public Iterator<String> iterator(){
				//拷贝数据创建序列
				List<String> shuffled=new ArrayList<String>(Arrays.asList(words));
				Collections.shuffle(shuffled);
				return shuffled.iterator();
			}
		};
	}
	
	public static void main(String[]args){
		MultiIterableClass mic=new MultiIterableClass();
		for(String s:mic.reversed()){
			System.out.print(s+" ");
		}
		System.out.println();
		for(String s:mic.randomized()){
			System.out.print(s+" ");
		}
		System.out.println();
		for(String s:mic){
			System.out.print(s+" ");
		}
		
	}
	
}
