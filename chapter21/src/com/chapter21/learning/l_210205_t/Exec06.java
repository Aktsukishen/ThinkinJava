package com.chapter21.learning.l_210205_t;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class RandomTask implements Runnable{
	public static int count=1;
	
	private final int id=count++;

	
	@Override
	public void run() {
		int rand=1000+new Random().nextInt(9000);
		try {
			TimeUnit.MICROSECONDS.sleep(rand);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("RandomTask id:"+id+" sleep:"+rand);
	}
	
}


public class Exec06 {
	public static void main(String[]args){
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exec.execute(new RandomTask());
		}
		exec.shutdown();
	}
}
