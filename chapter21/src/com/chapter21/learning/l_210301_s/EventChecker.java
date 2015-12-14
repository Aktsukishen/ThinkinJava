package com.chapter21.learning.l_210301_s;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author li.shensong
 *
 */
public class EventChecker implements Runnable {
	
	private IntGenerator generator;
	private final int id;
	public EventChecker(IntGenerator g,int id){
		this.generator=g;
		this.id=id;
	}
	public void run(){
		while(!generator.isCancled()){
			int val=generator.next();
			if(val%2!=0){
				System.out.println(val +" not even.");
				generator.cancle();
			}
		}
	}
	
	public static void test(IntGenerator g,int count){
		System.out.println("Press Ctrl-C to exit");
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<count;i++){
			exec.execute(new EventChecker(g, i));
		}
		exec.shutdown();
	}
	
	public static void test(IntGenerator g){
		test(g,10);
	}
}
