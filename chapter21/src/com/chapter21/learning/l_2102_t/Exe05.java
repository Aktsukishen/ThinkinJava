package com.chapter21.learning.l_2102_t;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exe05 {
	public static void main(String[]args){
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> arr = new ArrayList<>();
		
		for(int i = 10;i < 20 ; i++){
			arr.add(exec.submit(new FibonacciCallable(i)));
		}
		
		for(Future<Integer> fi : arr){
			try {
				System.out.println("result:" + fi.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		exec.shutdown();
	}
}
