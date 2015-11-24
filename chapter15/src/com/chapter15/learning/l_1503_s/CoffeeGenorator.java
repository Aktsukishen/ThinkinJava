package com.chapter15.learning.l_1503_s;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenorator implements Generator<Coffee>,Iterable<Coffee>{
	
	private Class[] types={Latte.class,Mocha.class,Cappuccino.class,Americano.class,Breve.class};
	
	private static Random rand=new Random(47);
	
	public CoffeeGenorator() {}
	
	private int size=0;
	
	private CoffeeGenorator(int size){this.size=size;}
	
	@Override
	public Coffee next() {
		try {
			return (Coffee) types[rand.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}

	class CoffeIterator implements Iterator<Coffee>{
		int count=size;
		
		@Override
		public boolean hasNext() {
			return count>0;
		}

		@Override
		public Coffee next() {
			count--;
			return CoffeeGenorator.this.next();
		}
	}
	
	public static void main(String[]args){
		CoffeeGenorator gen=new CoffeeGenorator();
		for(int i=0;i<5;i++){
			System.out.println(gen.next());
		}
		for(Coffee coffee:new CoffeeGenorator(5)){
			System.out.println(coffee);
		}
	}

	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeIterator();
	}
}
