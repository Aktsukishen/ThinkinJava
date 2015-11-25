package com.chapter15.learning.l_1504_s;

import com.chapter15.learning.l_1503_s.Generator;

public class BasicGeneratorDemo {
	public static void main(String[]args){
		Generator<CountedObject> gen=BasicGenerator.create(CountedObject.class);
		for(int i=0;i<5;i++){
			System.out.println(gen.next());
		}
	}
}
