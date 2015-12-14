package com.chapter21.learning.l_210301_s;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * AtomicInteger 原子性变量类，不会出现竞争状况
 * @author li.shensong
 *
 */
public class AtomicIntegerTest implements Runnable {
	private AtomicInteger i=new AtomicInteger(0);
	
	private int getValue(){
		return i.get();
	}
	
	private void evneIncrement(){
		i.getAndAdd(2);
	}
	
	@Override
	public void run() {
		while(true)
			evneIncrement();
	}

	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.err.println("Aborting");
				System.exit(0);
			}
		}, 5000);
		
		ExecutorService exec=Executors.newCachedThreadPool();
		AtomicIntegerTest ait=new AtomicIntegerTest();
		exec.execute(ait);
		while(true){
			int val=ait.getValue();
			if(val%2!=0){
				System.out.println(val);
				System.exit(0);
			}
		}
	}

}
