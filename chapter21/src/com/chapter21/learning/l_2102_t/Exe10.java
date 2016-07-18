package com.chapter21.learning.l_2102_t;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exe10 {
	public static void main(String[]args) throws InterruptedException, ExecutionException{
		ThreadMethod m = new ThreadMethod("method");
		for(int i = 10; i< 20; i++){
			System.out.println(i + ":" +m.runTask(i).get());
		}
	}
}

class ThreadMethod{
	private String name ;
	private ExecutorService executor;
	public ThreadMethod(String name){
		this.name = name;
	}
	public Future<Integer> runTask(int n){
		if( executor == null){
			executor = Executors.newCachedThreadPool();
		}
		return executor.submit(new FibonacciCallable(n));
	}
}

