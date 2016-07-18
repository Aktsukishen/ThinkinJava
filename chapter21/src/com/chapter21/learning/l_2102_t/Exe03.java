package com.chapter21.learning.l_2102_t;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exe03 {
	public static void main(String[]args){
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			exec.execute(new PrinterRunnable());
		}
		exec.shutdown();
		
		ExecutorService execFixed = Executors.newFixedThreadPool(10);
		for(int i=10;i<20;i++){
			execFixed.execute(new PrinterRunnable());
		}
		execFixed.shutdown();
		
//		exec.execute(new PrinterRunnable());
//		System.out.println("after shutdown");
	}
}
