package com.chapter17.learning.l_1702_s;

import java.util.Iterator;

import com.chapter15.learning.l_1503_s.Generator;

class Letters implements Iterable<Integer>,Generator<Pair<Integer,String>>{
	
	private int size=9;
	private int number=1;
	private char letter='A';
	
	public Pair<Integer,String> next(){
		return new Pair<Integer,String>(number++,""+(letter++));
	}
	
	@Override
	public Iterator<Integer> iterator(){
		return new Iterator<Integer>(){
			@Override
			public Integer next(){ return number++;}
			@Override
			public boolean hasNext(){
				return number<size;
			}
		};
	}
}

public class MapDataTest {

	public static void main(String[] args) {
		//Pair Generator
		System.out.println(MapData.map(new Letters(), 11));
		//Two separate generator
		//
		
	}

}
