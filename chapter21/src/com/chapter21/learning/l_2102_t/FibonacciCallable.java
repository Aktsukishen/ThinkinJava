package com.chapter21.learning.l_2102_t;

import java.util.concurrent.Callable;

public class FibonacciCallable implements Callable<Integer> {

	private int num;
	
	public  FibonacciCallable(int n) {
		this.num = n;
	}
	
	@Override
	public Integer call() throws Exception {
		return getFibonacci(num);
	}
	
	private int getFibonacci(int n){
		if ( n == 1 || n == 2){
			return 1;
		}else{
			return getFibonacci(n-1) + getFibonacci(n-2);
		}
	}

}
