package com.chapter11.learning.l_1101_s;

import java.util.ArrayList;

class Apple{
	private static long counter;
	private final long id=counter++;
	public long id(){
		return id;
	}
}

class Orange{}


public class ApplesAndOrangesWithoutGenerics {

	public static void main(String[] args) {
		ArrayList apples=new ArrayList();
		for(int i=0;i<3;i++){
			apples.add(new Apple());
		}
		apples.add(new Orange());
		for(int i=0;i<apples.size();i++){
			//没有类型参数，所以apples中的所有对象都是Object，因此默认都可以加入。而在去除时转型在编译器也没法发现错误
			((Apple)(apples.get(i))).id();
		}
	}

}
