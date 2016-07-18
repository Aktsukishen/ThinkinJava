package com.chapter21.learning.l_2102_t;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exe06 {

	public static void main(String[] args) {
		ExecutorService  exec =  Executors.newCachedThreadPool();
		for(int i=0 ; i<10;i++){
			exec.execute(new SleepRunnable());
		}
		exec.shutdown();
	}

}

class SleepRunnable implements Runnable{
	static int count = 1;
	int id = count ++;
	
	@Override
	public void run(){
		Random random = new Random();
		int time = 1 + random.nextInt(10);
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Sleeper " + id  + " sleep " + time  +"s");
	}
}
