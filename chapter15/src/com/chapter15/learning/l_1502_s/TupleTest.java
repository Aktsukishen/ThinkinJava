package com.chapter15.learning.l_1502_s;

class Amphinian{}

class Vehicle{}

public class TupleTest {

	static TwoTuple<String, Integer> f(){
		return new TwoTuple<String, Integer>("hi", 47);
	}
	
	static ThreeTuple<Amphinian, String, Integer> g(){
		return new ThreeTuple<Amphinian, String, Integer>(new Amphinian(), "hi", 47);
	}
	
	static FourTuple<Vehicle, Amphinian, String, Integer> h(){
		return new FourTuple<Vehicle, Amphinian, String, Integer>
						(new Vehicle(),new Amphinian()	, "hi", 47);
	}
	
	static FiveTuple<Vehicle, Amphinian, String, Integer, Double>  k(){
		return new FiveTuple<Vehicle, Amphinian, String, Integer, Double>
					(new Vehicle(), new Amphinian(), "hi", 47, 11.1);
	}
	
	public static void main(String[]args){
		TwoTuple<String, Integer> ttsi=f();
		System.out.println(ttsi);
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
	}
}
