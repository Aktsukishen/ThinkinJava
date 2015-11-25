package com.chapter15.learning.l_1504_s;

import java.util.ArrayList;
import java.util.Collection;

import com.chapter15.learning.l_1503_s.Coffee;
import com.chapter15.learning.l_1503_s.CoffeeGenorator;
import com.chapter15.learning.l_1503_s.Fibonacci;
import com.chapter15.learning.l_1503_s.Generator;

public class Generators {

	public static <T> Collection<T> fill(Collection<T> coll,Generator<T> gen,int n){
		for(int i=0;i<n;i++){
			coll.add(gen.next());
		}
		return coll;
	}
	
	public static void main(String[]args){
		Collection<Coffee> coffee=fill(new ArrayList<Coffee>(),new CoffeeGenorator(),4);
		for(Coffee c:coffee){
			System.out.println(c);
		}
		Collection<Integer> fnumbers=fill(new ArrayList<Integer>(),new Fibonacci(),4);
		for(int i:fnumbers){
			System.out.println(i);
		}
	}
}
