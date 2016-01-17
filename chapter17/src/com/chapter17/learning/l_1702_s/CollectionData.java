package com.chapter17.learning.l_1702_s;

import java.util.ArrayList;

import com.chapter15.learning.l_1503_s.Generator;

public class CollectionData<T> extends ArrayList<T>{
	private static final long serialVersionUID = 1L;

	public CollectionData(Generator<T> gen,int quantity){
		for(int i=0;i<quantity;i++){
			add(gen.next());
		}
	}
	
	public static <T> CollectionData<T>  list(Generator<T> gen,int quantity){
		return new CollectionData<T>(gen, quantity);
	}
}
