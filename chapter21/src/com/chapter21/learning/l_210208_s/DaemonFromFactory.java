package com.chapter21.learning.l_210208_s;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable{

	@Override
	public void run(){
		try{
			while(true){
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread()+":"+this);
			}
		}catch(InterruptedException e){
			System.out.println("intterrupted");
		}
	}
	
	public static void main(String[] args) throws Exception{
		ExecutorService exec=Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0;i<10;i++){
			exec.execute(new DaemonFromFactory());
		}
		exec.shutdown();
		System.out.println("All Daemon started");
		TimeUnit.MILLISECONDS.sleep(1000);
		System.out.println("All Daemon ended");
	}

}
