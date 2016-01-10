package com.chapter11.learning.l_1101_s;

import java.util.ArrayList;

public class ApplesAndOrangesWithGenerics {

	public static void main(String[] args) {
		ArrayList<Apple> apples=new ArrayList<Apple>();
		for(int i=0;i<3;i++){
			apples.add(new Apple());
		}
		//加入类型参数可以在编译器就发现错误
//		apples.add(new Orange());
		for(int i=0;i<apples.size();i++){
			System.out.println(apples.get(i).id());
		}
		//Using foreach:
		for(Apple apple:apples){
			System.out.println(apple.id());
		}
	}

}
