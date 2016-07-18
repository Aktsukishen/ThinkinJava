package com.chapter21.learning.l_2102_t;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exe04 {

	public static void main(String[]args){
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i= 1;i < 10 ; i++){
			exec.execute(new FibonacciRunnable(i));
		}
		System.out.println("*********************");
		ExecutorService execFixed = Executors.newFixedThreadPool(10);
		for (int i =1 ; i< 11 ;i++){
			execFixed.execute(new FibonacciRunnable(i));
		}
	}
}
