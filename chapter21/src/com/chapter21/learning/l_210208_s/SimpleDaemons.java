package com.chapter21.learning.l_210208_s;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{
	@Override
	public void run(){
		try{
			while(true){
				TimeUnit.MILLISECONDS.sleep(10);
				System.out.println(Thread.currentThread()+" "+this);
			}
		}catch(InterruptedException e){
			System.out.println("sleep() interrupted");
		}
	}
	
	public static void main(String[]args) throws Exception{
		for(int i=0;i<5;i++){
			Thread thread=new Thread(new SimpleDaemons());
			thread.setDaemon(true);
			thread.start();
		}
		System.out.println("All dameons started");
		TimeUnit.MICROSECONDS.sleep(10000);
		System.out.println("All dameons ended");
	}
}
