package com.chapter15.learning.l_1503_s;

public class Fibonacci implements Generator<Integer>{

	@Override
	public Integer next() {
		return fib(count++);
	}
	
	private int count=0;
	
	private int fib(int n){
		if(n<2) return 1;
		return fib(n-1)+fib(n-2);
	}

	public static void main(String[]args){
		Fibonacci gen=new Fibonacci();
		for(int i=0;i<18;i++){
			System.out.print(gen.next()+" ");
		}
	}
}
