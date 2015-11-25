package com.chapter15.learning.l_1506_s;

import java.util.ArrayList;
import java.util.Random;

import com.chapter15.learning.l_1503_s.Generator;
import com.chapter15.learning.l_1504_s.Generators;

class Product{
	private final int id;
	private String description;
	private double price;
	public Product(int id, String description, double price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}
	public String toString(){
		return id+":"+description+",price: $"+price;
	}
	public void priceChange(double change){
		price+=change;
	}
	public static Generator<Product> generator(){
		return new Generator<Product>(){
			private Random rand=new Random(47);
			@Override
			public Product next() {
				return new Product(rand.nextInt(1000),"Test", Math.round(rand.nextDouble()*1000.0)+0.99);
			}
		};
	}
}

class Shelf extends ArrayList<Product>{
	public Shelf(int count){
		Generators.fill(this, Product.generator(), count);
	}
}

class Asile extends ArrayList<Shelf>{
	public Asile(int shelfCount,int productCount){
		for(int i=0;i<shelfCount;i++)
			add(new Shelf(productCount));
	}
}

class CheckoutStand{}
class Office{}

public class Store extends ArrayList<Asile>{
	private ArrayList<CheckoutStand> checkouts=new ArrayList<CheckoutStand>();
	private Office office=new Office();
	public Store(int nAsiles,int nShelves,int nProducts){
		for(int i=0;i<nAsiles;i++){
			add(new Asile(nShelves,nProducts));
		}
	}
	public String toString(){
		StringBuilder result=new StringBuilder();
		for(Asile a:this)
			for(Shelf s:a)
				for(Product p:s){
					result.append(p+"\n");
				}
		return result.toString();
	}
	
	public static void main(String[]args){
		System.out.println(new Store(14,5,10));
	}
}
